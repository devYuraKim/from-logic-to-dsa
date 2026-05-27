// Wed May 27 2026
// 갑자기 머리가 하얘져서 손도 못 댐...
class Solution {
    public int maxProfit(int[] prices) {

        int output=0; //maxProfit

        // 지금까지 내가 본 최저가격은(buying point) 얼마인가?
        int lowest=prices[0];

        for(int price: prices){

            if(price < lowest){
                lowest = price;
            }

            if(price-lowest > output){
                output = price - lowest;
            }

        }

        return output;

    }
}