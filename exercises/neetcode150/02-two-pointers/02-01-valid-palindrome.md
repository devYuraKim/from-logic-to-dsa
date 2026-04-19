### Optimized Code
```java
class Solution {
    public boolean isPalindrome(String s) {
        // 공간 최적화: 새로운 배열을 만들지 않고 인덱스로 접근
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // 1. 왼쪽 포인터 이동 (알파뉴메릭이 나올 때까지)
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // 2. 오른쪽 포인터 이동
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            // 3. 비교 (대소문자 무시를 위해 비교 직전에 처리)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        return true;
    }
}
```

### My Code
```java
class Solution {
    public boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();
        char[] charArray = lowerCase.toCharArray();

        int leftPointer = 0;
        int rightPointer = charArray.length-1;

        while(leftPointer < rightPointer){ //이렇게 해야 leftPointer++ 했을 때 rightPointer랑 같아질 수 있으니까
        //while(leftPointer <= rightPointer){
            while(leftPointer < rightPointer && !Character.isLetterOrDigit(charArray[leftPointer])){
                //if(leftPointer < rightPointer) leftPointer++;
                leftPointer++;
            }
            while(leftPointer < rightPointer && !Character.isLetterOrDigit(charArray[rightPointer])){
                //if(leftPointer < rightPointer) rightPointer--;
                rightPointer--;
            }
            
            if(charArray[leftPointer]==charArray[rightPointer]){
                leftPointer++;
                //rightPointer++;
                rightPointer--;
            }else{
                return false;
            }
        }

        return true;

        }
}

// ASCII a=26, z=26+26=52
// s.toCharArrays?

// String lowerCase = s.toLowerCase();
// 처리1. white space 어떻게 없앨까?
// 처리2. 0-9는 어떻게 관리해야 할까? a-z 다음이 0-9인가? 그러면 52+10=62?
// 그러면 charArray[i]가 26-62사이에 들어오는 것들만 남겨서 새로 array 만들 수 있나?
// char[] charArray = lowerCase.toCharArray();
// ["w","a","s"," ","i","t"," ","a",...,"?"]

// int newCharArrayLength = word.length();
// for(int i = 0; i < word.length; i++){
//     if(charArray[i] < 26 || charArray[i] > 62){
        
//     }
// }



// Gemini guidance
// Character.isLetterOrDigit(char) 활용할 것

// {
//     String lowerCase = s.toLowerCase();
//     char[] charArray = lowerCase.toCharArray();

//     int leftPointer = 0;
//     int rightPointer = charArray.length()-1;

//     while(leftPointer <= rightPointer){
//         while(!Chracter.isLetterOrDigit(charArray[leftPointer])){
//             leftPointer++;
//         }
//         while(!Character.isLetterOrDigit(charArray[rightPointer])){
//             rightPointer--;
//         }
        
//         if(charArray[leftPointer]==charArray[rightPointer]){
//             leftPointer++;
//             rightPointer++;
//         }else{
//             return false;
//         }
//     }

//     return true;
// }
```

> 음 내 생각에는 이번 문제에서 내가 정리해야 할 내용은    
> (1) while 종료 조건(언제 종료가 되고, 언제 계속 되는가)     
> (2) two pointer 경계조건     
> (3) Character 관련 메소드


네, 정확합니다. 이번 문제를 통해 정리해야 할 핵심 지식들을 짚으셨습니다. 각 항목이 왜 중요한지, 그리고 어떤 점을 머릿속에 각인해야 하는지 정리해 드리겠습니다.

### (1) `while` 종료 조건: "진전(Progress)과 루프 탈출"
가장 중요한 포인트는 "**루프가 멈추지 않는 상황을 어떻게 방지할 것인가**"입니다.
* **핵심:** <mark>`while` 문은 조건식이 `false`가 되어야만 멈춥니다.</mark>
* **배운 점:** 루프 내부에서 `if` 문으로 실행 로직을 감쌀 때, `if` 조건이 맞지 않아 아무런 포인터 이동(`left++` 등)이 일어나지 않으면 **무한 루프**에 빠진다는 것을 확인했습니다.

### (2) Two Pointer 경계 조건: "안전제일(Short-circuit)"
배열이나 문자열의 인덱스를 직접 다룰 때 발생하는 `IndexOutOfBoundsException`을 방지하는 기술입니다.
* **핵심:** 포인터를 이동시키는 내부 `while` 루프에서도 **외부 루프의 경계 조건(`left < right`)을 다시 한번 확인**해야 합니다.
* **배운 점:** 자바의 `&&` 연산자는 **단락 평가(Short-circuit)**를 수행합니다. 즉, `left < right`가 앞부분에서 먼저 `false`가 되면 뒷부분의 `charAt(left)`는 실행조차 하지 않아 안전합니다.

### (3) Character 관련 메소드: "바퀴를 다시 발명하지 마라"
알파벳인지, 숫자인지, 대소문자인지 직접 ASCII 숫자로 비교하는 것은 가독성이 떨어지고 실수하기 쉽습니다.
* **핵심:** `java.lang.Character` 클래스의 정적 메소드들을 활용하는 습관을 들여야 합니다.
* **필수 메소드:**
    * `Character.isLetterOrDigit(char)` : 알파벳 또는 숫자 여부 확인.
    * `Character.toLowerCase(char)` / `Character.toUpperCase(char)` : 개별 문자 케이스 변경.
    * `Character.isWhitespace(char)` : 공백 확인.

---

### 추가로 가져가면 좋은 정보: 공간 복잡도(Space Complexity)
질문자님이 처음에 작성하신 코드와 마지막 코드를 비교해 보세요.
* **처음:** `toLowerCase()`로 전체 문자열 복사본 생성 + `toCharArray()`로 배열 생성 $\rightarrow$ 메모리 사용량 $O(N)$
* **발전:** 원본 문자열에서 `charAt()`으로 직접 비교 $\rightarrow$ 메모리 사용량 $O(1)$ (추가 메모리 거의 없음)



이 세 가지 포인트(종료 조건, 경계 검사, 표준 라이브러리 활용)는 팰린드롬 문제뿐만 아니라, 거의 모든 **문자열/배열 기반 알고리즘 문제의 기초**가 됩니다. 이 개념들이 확실히 정리되었다면, 다음에는 '이진 탐색(Binary Search)'이나 '슬라이딩 윈도우(Sliding Window)' 같은 더 복잡한 포인터 제어 문제로 넘어가셔도 충분합니다.

더 궁금한 점이나, 이 로직을 적용해보고 싶은 다른 문제가 있으신가요?