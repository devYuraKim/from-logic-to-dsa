// Wed Apr 22, 28:32

class Solution {
    public int rob(int[] nums) {

        //이거 없었는데 submit 하니까 length==1인 경우 오류 나서 추가
        if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length+1];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // for(int i=2; i < nums.length+1; i++){
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }

        // reutnr dp[nums.length];
        return dp[nums.length-1];

    }
}

// dp[i] = i번째 집을 털기로 했을 때 얻게 되는 max profit
// dp[0] = 1;
// dp[1] = 1;
// dp[2] = 1 + 3 = 4;
// dp[3] = 3 + 1 = 4;

// dp[0] = 2;
// dp[1] = 9;
// dp[2] = 2+8 = 10;
// dp[3] = 3+9 = 12;
// dp[4] = 2+8+6 = 16;

// 음... 그런데 이거 그냥
// 0 + 2 + 4 + ...
// 1 + 3 + 5 + ...
// 이거 아냐...?
// 딱 두 경우 아냐...?

// 아닌 경우 찾았다
// [5, 1000, 3, 12, 100, 5, 7, 1]
// dp[0] = 5;
// dp[1] = 1000;
// dp[2] = 1000;
// dp[3] = 1000+12 = 1012;
// dp[4] = 100+1000 = 1100;

// dp[i] = i번째 집을 털었을 때 얻게 되는 max profit
// 서로 연속하면 안 된다는 어떻게 코드로 표현해야 할지 모르겠음
// 어쩌면 이걸 코드로 표현하지 않아도 될 수도?

// dp[0] = nums[0];
// dp[1] = Math.max(nums[0], nums[1]); // 5 vs 1000 => 1000
// dp[2] = Math.max(dp[0]+nums[2], dp[1]); // 5+3=8 vs 1000 => 1000
// dp[3] = Math.max(dp[1]+nums[3], dp[2]); // 1000+12 vs 1000 => 1012
// dp[4] = Math.max(dp[2]+nums[4], dp[3]); // 1000+100 vs 1012 => 1100
// dp[5] = Math.max(dp[3]+nums[5], dp[4]); // 1012+5 vs 1100 => 1100;