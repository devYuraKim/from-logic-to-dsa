// Thu Apr 23, 거의 1시간이라고 보면 될 듯 (55분 정도?)

class Solution {
    public int coinChange(int[] coins, int amount) {

        //int[] dp = new int[coins.length];
        int[] dp = new int[amount+1];

        dp[0] = 0;

        // for(int i = 0; i < coins.length; i++){
        //     if( i - coins[i] < 0 ) continue;
        //     if ( i - coins[i] > 0 ) {
        //         dp[i] = Math.min(dp[i-coins[i]]+1, dp[i-coins[i+1]]+1,, ... dp[i-coins[coins.length-1]]+1);
        //     }
        // }

        // Gemini Feedback(1): dp[i] 정의가 "금액 i를 만드는 최소 동전"이잖아. 그러면 i가 0부터 amount까지 가야 하지 않아? 그러니까 i는 amount지
        for(int i = 1; i < amount + 1; i++){
            // Gemini Feedback(3): amount+1로 'impossible' 표현해라
            // dp[i] = amount;
            dp[i] = amount + 1;
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] < 0){
                    // Gemini Feedback(2): 그냥 continue 해라
                    //dp[i] = -5000;
                    continue;
                }else{
                    int currentMin = dp[i-coins[j]]+1;
                    if(currentMin < dp[i]) { dp[i] = currentMin; }
                }
            }
        }

        // Gemini Feedback(4): -1인 경우 이렇게 return 해라
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

// dp[i] = 금액 i를 만드는 데 필요한 최소한의 동전
// dp[0] = 0;
// dp[1] = dp[1-1] = 1;
// dp[2] = dp[2-1] + 1 = 2;
// dp[3] = dp[3-1] + 1 = 3;
// dp[4] = dp[4-1] + 1 = 4;
// dp[5] = Math.min(dp[5-1]+1, dp[5-5]+1) = Math.min(5, 1) = 1;
// dp[6] = Math.min(dp[6-1]+1, dp[6-5]+1) = Math.min(2, 2) = 2;
//
// dp[11] = Math.min(dp[11-10]+1, dp[11-5]+1, dp[11-1]+1)

// dp[0] = 0;
// dp[1] = dp[1-2] = impossible;
// dp[2] = dp[2-2] + 1 = 0;
// dp[3] = dp[3-2] + 1 = impossible;