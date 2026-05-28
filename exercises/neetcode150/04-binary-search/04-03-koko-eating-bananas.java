// Thu May 28 2026
// 19'20''
class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int minRate = 1;
        int maxRate = 1;

        for(int pile : piles){
            maxRate = Math.max(maxRate, pile);
        }

        // 이걸 여기에 두니까 당연히 안 되지... 어휴...
        // int totalHours = 0;

        while(minRate < maxRate){
            int totalHours = 0;

            int midRate = minRate + (maxRate-minRate)/2;

            for(int pile:piles){
                totalHours += (pile + midRate - 1)/midRate;
            }

            if(totalHours > h){
                minRate = midRate+1;
            }else{
                maxRate = midRate;
            }
        }

        return minRate;

    }
}

// min=1, max=25, mid=13
// total = 2+1+2+1 = 5 > 4, min=14
// min=14, max=25, mid=19
// total = 2+1+2+1 = 5 > 4, min=20
// min=20, max=25, mid=22
// total=2+1+2+!, min=23
// min=23, max=25, mid=24
// total=2+1+1+1=5, mid=25

// min=1, max=11, mid=6
// tot = 1+1+2+2 = 6 < 8, max=mid=6
// min=1, max=6, mid=3
// tot = 1+2+3+4 = 10 > 8, min=mid+1=4
// min=4, max=6, mid=5
// tot = 1+2+2+3 = 8 <=8, max=mid=5
// min=4, max=5, mid=4
// tot = 1+2+2+3 = 8 <=8, max=mid=4
// min=4, max=4, mid