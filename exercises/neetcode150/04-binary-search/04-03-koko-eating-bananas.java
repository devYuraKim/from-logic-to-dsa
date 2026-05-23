// Sat May 23 2026
// 14'03''
// while(minRate <= maxRate) 했다가 TLE

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int minRate = 1;
        int maxRate = 1;

        for(int pile: piles){
            if(pile>maxRate){
                maxRate = pile;
            }
            // 이거 Math.max(maxRate, pile); ?
            // 아니, math = Math.max(maxRate, pile)로 재할당 필요
            //maxRate = Math.max(maxRate, pile);
        }

        while(minRate < maxRate){
            int totTime = 0;
            int midRate = (minRate+maxRate)/2;

            for(int pile: piles){
                if(pile % midRate != 0){
                    totTime += pile/midRate + 1;
                }else{
                    totTime += pile/midRate;
                }
                // 이거 totTime += (pile+midRate-1)/midRate; ?
                // 이 공식 맞음
                // totTime += (pile+midRate-1)/midRate;
            }

            if(totTime > h){
                minRate = midRate+1;
            }else{
                maxRate = midRate;
            }
        }

        return minRate;

    }
}
