```java
m*n
(r,c) (0,0) (0,1) (0,2) 

// 여기에서 이미 다 걸림
if(r == 0 || r == n-1 || c == 0 || c == m-1) { 
return {-1, -1}
}

// 각 방향으로 갔을 때, 현재의 grid 값보다 작은 grid 값만 찾음
// 그 값들 중에 최소값을 찾음
// *** 다음 위치를 찾는 것이 목적

int r_next = r;
int c_next = c;
int curMin = input[r][c];

if(input[r-1][c] < input[r][c]) {
	curMin = input[r-1][c];
}
if(input[r+1][c] < input[r][c] && input[r+1][c] < curMin ) {
	curMin = input[r+1][c];
}



(r,c)
// 상방 이동 r>=1일 때부터 고려
(r-1, c) < (r,c) 확인
// 하방 이동: r<=n-2 아닌지 확인
(r+1, c) < (r,c) 확인
// 좌측 이동: c>=1
(r, c-1) < (r,c) 확인
// 우측 이동: c <= m-2
(r, c+1) < (r,c) 확인

// 사방 중에 최솟값
// grid 안의 값 추적

if( r>=1 && input[r-1][c] < input[r][c]) {
input[r][c] = “{“ + r + “,” + c + “}”
} else if ( r<=2 n-2 && input[r+1][c] < input[r][c] ){
	input[r][c] = “{“ + r + “,” + c + “}”
}


if( r>=1 )
```