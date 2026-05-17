// Sun May 17 2026
// 8'48''
class Solution {
    public int maxProfit(int[] prices) {

        int output = 0;
        int pastLow = prices[0];

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