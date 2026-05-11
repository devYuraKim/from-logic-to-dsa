// Mon May 11
// Brute Force (TLE error)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = piles[0];

        for(int baCount : piles){
            if(max < baCount){
                max = baCount;
            }
        }


        for(int k = 1; k <= max; k++){

            int totalHours = 0;

            for(int baCount : piles){

                if(baCount % k != 0){
                    totalHours += baCount/k + 1;
                }else{
                    totalHours += baCount/k;
                }

            }

            if(totalHours <= h){
                return k;
            }
        }

        return -1;

    }
}
