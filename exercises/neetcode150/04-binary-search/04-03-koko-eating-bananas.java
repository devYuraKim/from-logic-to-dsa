// Tue May 12 2026
// 25'21''경에 LLM feedback 받아서 26'21''

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int min = 1;
        int max = piles[0];

        for(int pile : piles){
            if(max < pile) {
                max = pile;
            }
        }

        while(min <= max){

            int k = (min+max)/2;
            int totalHours = 0;

            for(int pile : piles){
                if(pile % k != 0){
                    totalHours += pile/k + 1;
                }else{
                    totalHours += pile/k;
                }
            }

            if(totalHours > h){
                min = k + 1;
            }if(totalHours <= h){
                max = k - 1;
            }

            //여기서 totalHours <= h가 되는 최소 k를 어떻게 포착하지?
            // if(min==max) return k;

        }

        // return -1;
        return min;
    }
}

// min 1, max 11 k==6
// [1+1+2+2] = 6
// min 1, max 6 k==3
// [1,2,3,4] = 10
// min 4, max 6 k==5
//

// min 1, max 4 k==2
// [1+2+2+1] = 6
// min 1, max 1 k==1
// [1+4+3+2] = 10

// min 4, max 25 k==14
// [2+1+2+1] = 6
// min 15, max 25 k==20
// [2+1+2+1] = 6
// min 21, max 25 k==23
// [2+1+1+1] = 5
// min 24, max 25 k==24
// [2+1+1+1] = 5
// min 25, max 25 k==25