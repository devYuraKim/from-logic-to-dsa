// Sat May 16 2026
// 10'32''

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int minK = 1;
        int maxK = 1;

        for(int pile : piles){
            if (pile > maxK){
                maxK = pile;
            }
        }

        while(minK <= maxK){

            int midK = (minK + maxK) / 2;
            int totalHours = 0;

            for(int pile : piles){
                if(pile % midK != 0){
                    totalHours += pile/midK + 1;
                }else{
                    totalHours += pile/midK;
                }
            }

            if(totalHours > h){
                minK = midK + 1;
            }

            if(totalHours <= h){
                maxK = midK - 1;
            }

        }

        return minK;

    }
}
