> **문제1**: 
> `while(left < right)`     
> `left == right`일 때, 즉 탐색 범위가 원소 하나로 좁혀졌을 때 루프가 종료되어 해당 원소를 확인하지 못하고 `false`를 반환함. `<=`로 수정해야 마지막 원소까지 체크 가능.

> **문제2**:
> `int row = half / colCount;`     
> `1-based index`를 쓸 경우, `half`가 `colCount`의 배수일 때(= 각 행의 마지막 원소) `half / colCount`가 실제 `row`보다 1 크게 계산됨.     
> 예: `colCount=4`, `half=4`이면 `row`는 `0`이어야 하는데 1이 나옴. `half % colCount == 0`인 경우 `half/colCount - 1`로 처리해야 함.

> **문제3**: 
> `half = (left+right)/2;`     
> `left` 또는 `right`를 갱신한 직후 루프 내부에서 `half`를 재계산하고 있으나, 이 값은 이후 코드에서 사용되지 않고 다음 iteration 첫 줄에서 어차피 덮어씌워짐. 완전히 불필요한 코드.

> **문제4**:
> `int col = half % colCount == 0 ? col = colCount-1 : half % colCount -1;`     
> 삼항 연산자 내부에서 다시 대입 `col =` 사용.


### Original Code

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        int left = 1;
        int right = rowCount * colCount;
        
        while(left < right){
            int half = (left+right) / 2;

            int row = half / colCount;
            int col = half % colCount == 0 ? col = colCount-1 : half % colCount -1;

            if(target == matrix[row][col]){
                return true;
            }else if(target > matrix[row][col]){
                left = half+1;
                 half = (left+right)/2;
            }else {
                right = half-1;
                 half = (left+right)/2;
            }
        }

        return false;

    }
}
```

### Corrected Code
```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        int left = 1;
        int right = rowCount * colCount;

        while(left <= right){
            int half = (left+right) / 2;

            int row = half % colCount == 0 ? half/colCount - 1 : half / colCount;
            int col = half % colCount == 0 ? colCount-1 : half % colCount -1; 

            if(target == matrix[row][col]){
                return true;
            }else if(target > matrix[row][col]){
                left = half+1;
            }else {
                right = half-1;
            }
        }

        return false;

    }
}
```
