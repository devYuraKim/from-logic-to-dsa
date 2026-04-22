//Wed Apr 22

// approach 1: bottom up array
class Solution {
    public int climbStairs(int n) {

        //int[] dp = new [n+1]();
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}

// distinct
// 1 or 2
// n = 1, 1

// 또 같은 질문: 이건 왜 DP로 접근해야 하지?


// approach 2
class Solution {
    public int climbStairs(int n) {

        if(n==0) return 0;
        if(n==1) return 1;

        int prev1 = 1;
        int prev2 = 1;
        int current = 0;

        for(int i = 2; i < n+1; i++){
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }

        return current;
    }
}