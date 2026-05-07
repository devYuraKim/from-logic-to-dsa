26 Apr 30
```java

int countTwo = n/2; //2의 최대 갯수
int countOne = n%2; //2가 최대일 때 1의 갯수

// 여기서 수학적으로 사고하지 말고, 컴퓨터공학적으로 사고하라고 코멘트 받음
a(0), a(n) 을 구하는 방법을 a(n-1) 를 어떻게 해서 한다.


n-1
n-2
==0

1,1,2


String seqOne;
String seqTwo;

while(n-1==0){
	seqOne.append(‘1’);
}

//무한루프 해결 되었다고 치고 코드 진행
while(n-2==0){
	seqTwo.append(‘2);
}

```

26 May 6
```java

public List<String> sequences(int target){

    List<String> output = new ArrayList<>();
    String tempString = "";

    recursion(target, tempString, output);

    return output;

}

public void recursion(int target, String tempString, List<String> output){
    
    if(target == 0){
        output.add(tempString);
        return;
    }

    if(target < 0){
        return;
    }

    //1을 선택하는 경우
    recursion(target-1, tempString+"1", output);

    //2를 선택하는 경우
    recursion(target-2, tempString+"2", output);

}

```