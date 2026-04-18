class Solution {
    public int uniquePaths(int m, int n) {

        // 이거 정의 안 해서 오류 났었음
        // 틀림: int[] dp = [m][n];
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){ //row
            for (int j=0; j < n; j++) { //column
                if( i == 0 || j == 0 ) {
                    dp[i][j] = 1; //base case
                }else {
                    // 여기서 return 때리면 어쩌니 멍청아...
                    // return dp[i][j-1] + dp[i-1][j];
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        // 이건 또 뭘 반환하라는 거니 멍청아...
        // return dp;
        return dp[m-1][n-1];
    }
}

// random coordinate [c][r]
// to right: [c+1][r] (condition: c+1 =< m-1)
// to below: [c][r+1] (condition: r+1 =< n-1)

// unique paths
// starting point: only right or below

// my question: unique paths를 찾는 데 왜 DP를 써야 하냐?
// 이전까지 찾은 unique한 방식의 길의 총합을 구했다고 가정하자

// 어떤 한 무작위 지점 [c][r]에서 그 이전 상태는 둘 중 하나
// (1) 이전에 위에 있었음: [c][r-1] (0 <= r-1 <= n-1)
// (2) 이전에 왼쪽에 있었음: [c-1][r] (0 <= c-1 <= m-1)

// 특정 상태 s 직전까지의 unique한 경로의 합 (u_sum(s-1))
// 특정 상태 s에서의 unique한 경로의 합은?
// u_sum(s) = u_sum(s-1) + p_count(1 또는 2)

// 특정 좌표에서 가능한 이동 경우의 수
// p_count(0,0) = 2
// p_count(0,1) = 2
// p_count(0,2) = 1
// p_count(1,0) = 2
// p_count(1,1) = 2
// p_count(1,2) = 1
// ...
// p_count(5,0) = 1
// p_count(5,1) = 1
// p_count(5,2) = 1

// p_count([c][n-1]) = 1
// p_count([m-1][r]) = 1
// p_count(else) = 2

// 갑자기 '유니크한 경로의 수'를 어떻게 셀 것인지 의문이 생김
// 왜냐하면 2x2 grid에서 (0,0)에서 (1,1)까지 '유니크한 경로의 수'는 2개임
// 그리고 3x2 grid에서 (0,0)에서 (2,1)까지 '유니크한 경로의 수'는 3개임


// 여기에서 Gemini한테 guidance 요청
// 정의 변경 dp[c][r] = (c,r)에 도달하는 유니크한 경로의 수
// dp[c][r] = 위에서 들어오는 경우 + 왼쪽에서 들어오는 경우
//          = dp[c][r-1] + dp[c-1][r] (단, r-1 => 0 && c-1 => 0)
// 따라서 dp[c][r] = dp[c][r-1] + dp[c-1][r]
// c와 r의 범위 설정
// 0 =< c =< m-1  <->  0 =< c =< 99  <->  -1(x) 0 =< c-1 =< 98
// 0 =< r =< n-1  <->  0 =< r =< 99  <->  -1(x) 0 =< r-1 =< 98

// c-1 == 0인 경우, dp[0][0 - (n-1)] = 1
// **정의로 돌아가**
// dp[0][0] = (0,0)까지 가는 유니크한 경로의 수 = 1
// dp[0][1] = (0,1)까지 가는 유니크한 경로의 수 = 1
// dp[0][2] = (0,2)까지 가는 유니크한 경로의 수 = 1
// ... dp[0][n-1] = 1

// r-1 == 0인 경우 dp[0 - (m-1)][0]
// dp[0][0] = 1
// dp[1][0] = 1
// dp[2][0] = 1
// ... dp[m-1][0] = 1

// dp[m-1][n-1] = dp[m-1][n-2] + dp[m-2][n=-1]
// dp[0][*] = 1, dp[*][0] = 1
// dp[0][0] = dp[0][-1] + dp[-1][0] = n/a


// 여기에서 Gemini한테 2차 guidance 요청
// 1. 경계 조건(Boundary Condition)의 부재
// 수식에서 dp[c][r] = dp[c][r-1] + dp[c-1][r]이라고 정의했을 때, $c=0$이거나 $r=0$인 경우를 수식 내에 강제로 포함시키려다 보니 인덱스가 $-1$이 되는 상황이 발생.
// 잘못된 접근: 모든 $c, r$에 대해 하나의 식을 적용 → dp[0][0] = dp[0][-1] + dp[-1][0] (인덱스 오류)
// 올바른 접근: 범위를 분리
// $c=0$ 또는 $r=0$인 경우 (가장자리): $1$로 고정.
// $c=>1$ 이고 $r=>1$인 경우 (내부): $dp[c][r-1] + dp[c-1][r]$ 적용.

// (1) c == 0 || r==0, dp[0][*] = 1, dp[*][0] = 1
// (2) c => 1 && r => 1, dp[c][r] = dp[c][r-1] + dp[c-1][r]

// *** 주의 *** 수학적 좌표계와 프로그래밍 배열 표현 차이
// array[row][column]
// for(int i = 0; i < n; i++){ //row
//      for (int j=0; j < m; i++) { //column
//          if( i == 0 || j == 0 ) return 1; //base case
//          return dp[c][r-1] + dp[c-1][r];
//      }
//}
