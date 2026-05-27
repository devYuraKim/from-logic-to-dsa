// Wed May 27 2026
// sliding window approach - first try
class Solution {
    public int maxProfit(int[] prices) {

        int left = 0;
        int right = left+1;

        int output = 0;

        while(right<prices.length){
            int result = prices[right]-prices[left];
            if(result>0){
                output = Math.max(output, result);
            }else{
                left=right;
            }
            right++;
        }
        return output;
    }
}