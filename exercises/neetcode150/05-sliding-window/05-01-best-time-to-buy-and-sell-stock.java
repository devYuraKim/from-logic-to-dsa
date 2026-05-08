//17'53''
class Solution {
    public int maxProfit(int[] prices) {

        int pastLow = prices[0];
        int maxProfit = 0;

        for(int price: prices){
            if(price < pastLow){
                pastLow = price;
            }

            int profit = price - pastLow;
            if( profit > maxProfit ){
                maxProfit = profit;
            }
        }

        return maxProfit;

    }
}