### My Code
17'53''
```java
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
```

### Polished Code
```java
class Solution {

    public int maxProfit(int[] prices) {

        int pastLow = prices[0];
        int maxProfit = 0;

        for(int price : prices) {
            maxProfit = Math.max(maxProfit, price - pastLow);
            pastLow = Math.min(pastLow, price);
        }

        return maxProfit;
    }
}
```