// Wed Apr 22, 33분 걸림

class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length+1];

        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2; i < cost.length+1; i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
            // dp[2] = Math.min( dp[1]+cost[1], dp[0]+cost[0] ) = Math.min(2, 1) //dp[2] = 1
            // dp[3] = Math.min( dp[2]+cost[2], dp[1]+cost[1] ) = Math.min(1+3, 0+2) = 2

            // dp[2] = Math.min( dp[1]+cost[1], dp[0]+cost[0] ) = Math.min(2, 1) = 1;
            // dp[3] = Math.min( dp[])

        }

        return dp[cost.length];
    }
}

// 이게 또 왜 DP인가? 늘 이걸 딱 떨어지게 설명을 못 하겠음

// dp[i]의 정의: "i"번째 인덱스에 이르기까지의 최소 비용
// dp[i] = Math.min(dp[i-1], dp[i-2]) + min(cost[i-1], cost[i-2]);

// cost[0] 또는 cost[1]에서 시작 가능
// Math.min(cost[0], cost[1]);

// dp[0] = 0;
// dp[1] = 0;
// dp[2] = 1;
// dp[3] = 2;

// dp[0] = 0;
// dp[1] = 0;
// dp[2] = 1;
// dp[3] = 2;
// dp[4] = 2;
// dp[5] = 3;
// dp[6] = 4;
// dp[7] = 4;

// dp에서는 미래의 비용에는 관심이 없음
// 현재 기준으로 값을 비교함
// dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);