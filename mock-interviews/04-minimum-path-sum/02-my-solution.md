```text
m = 1, n = 1
start = (0, 0)
end = (0, 0)

m = 2, n = 2
start = (0, 0)
end = (1, 1)

// start (0,0) end (m-1,n-1)
// end(m,n) --> 난 이거라고 생각했었음, 그런데 interviewer intervention으로 수정함

// interviewer가 '임의의 한 좌표에서 움직이는 경우' 생각해보라고 함
// cur (x, y)
// (1) (x+1, y), x+1 =< m-1
// (2) (x, y+1) y+1 <= n-1

// interviewer intervention 내가 좌표를 수학적 좌표랑 혼동한 부분
m = 2
n = 3
grid[x][y] = [
[0, 1, 2],
[3, 4, 5],
];
[
   [[0, 0], [0, 1], [0, 2]],
   [[1, 0], [1, 1], [1, 2]],
]

cur (x, y)
(1) 상방에서 하방으로 이동한 경우, 이전 상태 (x-1, y) x-1>=0      // (x, y-1), y<=0
(2) 좌에서 우로이동, 이전 상태 (x, y-1), y>=0


// interviewer intervention: DP의 정의에서 work up
a(0) = 의 답을 알고
a(n - 1) 이 답이라고 가정할때, a(n-1)을 이용해서 a(n)의 답을 구하면
모든 a(n)의 답을 구할 수 있다.

int minSum ( List<Int> grid ) {

           // 이건 session wrapup 때 interviewr가 제시한 guidance
           a[0][0~n-1]
           a[0~m-1][0]

           a[0][0] = grid[0][0]
           
           a[0][1~n-1] = 옆에서만 왔을 경우
           a[1 ~ m - 1][0] = 위에서만 왔을 경우

	int 
	vector<vector<int>> a(m, vector<int>(n, 0));

           a[i-1][j] = (i-1, j)까지 가는 모든 경로에서의 최저 합.
           a[i][j - 1] = (, j - 1)까지 가는 모든 경로에서의 최저 합.
           a[i][j] = min(a[i-1][j], a[i][j-]) + grid[i][j]
	
    
    // 이게 내가 시도했던 DP concept application
    
    // interviewer intervention: 위에 적은 정의는 '1차원 일 때'인데, 그러면 어떻게 바뀌어야 하는가?
    // 나는 Math.min(a,b)가 그 두 경우를 handling하지 않나 생각해서 계속 모르겠었음
    // 사실 지금도 모르겠음
    a(n-2)min + Math.min(grid[x-1][y], grid[x][y-1])
	a(n-1)min + grid[x][y]

	a(n-2)min + Math.min(grid
	

	grid[x][y] + Math.min(grid[x+1][y], grid[x][y+1]);

}



1. DP의 정의는 알았는데, 그걸 그래서 어떻게 개별 케이스에 적용할 건데
2. index 관리할 때, 0부터 시작해서 (값-1)이 최댓값 되는 거 언제 익숙해질 건데
3. 좌표 오른쪽 이동이 (x, y+1)이고 아래쪽 이동이 (x+1,y)라는 거 
4. 특정 cell의 값 grid[x][y]와 n번째까지의 minSum이 다른 state로 관리된다는 거 왜 헷갈렸는데...


```