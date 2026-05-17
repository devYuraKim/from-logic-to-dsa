### My Code
Sun May 17 2026     
8'48''
```java
class Solution {
    public int maxProfit(int[] prices) {

        int pastLow = prices[0];
        int output = 0;

        for(int price : prices){

            if(pastLow > price){
                pastLow = price;
            }

            if(price - pastLow > output){
                output = price - pastLow;
            }

        }
        return output;
    }
}

// [10,1,5,6,7,1]
// i==0, 
// i==1, -10    +1
// i==2, -10,-1    +5
// i==3, -10,-1,-5    +6 
// i==4, -10,-1,-5,-6,    +7
// i==5, -10,-1,-5,-6,-7  +1
```

### Polished Code
```java
class Solution {

    public int maxProfit(int[] prices) {

        int pastLow = prices[0];
        int output = 0;

        for(int price : prices) {
            output = Math.max(output, price - pastLow);
            pastLow = Math.min(pastLow, price);
        }

        return output;
    }
}
```