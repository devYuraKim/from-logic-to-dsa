//approach 1: brute force
class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            //buying price
            // prices[i]

            //selling price
            // prices[i+1] - prices[prices.length-1]
            // selling price를 어떻게 비교해야 하지?
            // loop 안에서 loop을 돌려보자

            for(int j = i+1; j < prices.length; j++){
                if(prices[j]-prices[i] <= 0){
                    continue;
                }else{
                    if(prices[j]-prices[i] > maxProfit) {
                        maxProfit = prices[j]-prices[i];
                    }
                }
            }
        }
        return maxProfit;
    }
}

// prices[i]를 택하고, [i+1] 부터 [prices.length-1]까지의 차액을 비교해서
// 차액이 음수면 버리고, 양수면 업데이트해서 가장 큰 값 찾기

// approach 2: dp로 접근한다면 어떨까?
class Solution {
    public int maxProfit(int[] prices) {

        // buying price
        int pastMin = prices[0];
        // selling price
        //int futureMax = price[0];
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < pastMin) pastMin = prices[i];
            //if(prices[i] > futureMax) futureMax = prices[i];
            if(prices[i] - pastMin > maxProfit) maxProfit = prices[i] - pastMin;
        }

        return maxProfit;

    }
}

// dp는 내가 지금까지 결정한 것이 최적의 경로라고 가정하고, 마지막 스텝만 보는 것
// 그런데 현재 이 문제에서 그게 가능한가?