//6'23''
class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = -1;

        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                int currentProfit = prices[j] - prices[i];
                if(currentProfit > 0 && currentProfit>maxProfit){
                    maxProfit = currentProfit;
                }
            }
        }

        return maxProfit < 0 ? 0 : maxProfit;

    }
}
