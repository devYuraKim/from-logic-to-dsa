```java
Example : [4, 5, 1, 1, 3, 1, 0, 1]
        
// int n (length of the array)
// minimum 

// nums = [2,3,1,1,4]
// nums[0] - nums[0+nums[0]]  [2, 3, 1] 
// 저 범위 있는 수들 중에 max 값을 선택 -> 3 : 1번 사용, index[1]
// 생각의 끈을 다시 놓침 다시 잡음
// 3을 선택했을 때, 현재 index 1에서 3값을 더했을 때 n 보다 작거나 같은지 확인


(0, 1, 2, 3, 4, 5, 6, 7)
[4, 5, 1, 1, 3, 1, 0, 1]
// index 0 [4, 5, 1, 1, 3] -> max 5 선택, index 1 <점프 1회>
// index 1 + 5 = 6  < index 7 계속 [5, 1, 1, 3, 1, 0] -> max 선택 3, index 4 <1회>
// index 4 + 3 = 7 = index 7 종료 <1회>

minimum 3
```

pseudocode는 물론, 논리도 접근 못함. 와...    
심지어 저 예시로 구한 값도 틀림... 노답...