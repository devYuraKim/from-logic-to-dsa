// Mon May 18
// 51'03''
class Solution {
    public int jump(int[] nums) {

        if(nums.length==1){
            return 0;
        }

        int farthest = 0;
        int output = 0;
        int limit = 0;

        for(int i=0; i<nums.length-1; i++){
            int currentEnd = i + nums[i];
            if(currentEnd > farthest){
                farthest = currentEnd;
            }

            if(i==limit){
                limit = farthest;
                output++;
            }
        }

        return output;

    }
}

// [ 7,  0,  9,  6,  9,  6,  1,  7,  9,  0,  1,  2,  9,  0,  3 ]
// ( 0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14 )
// < 7,  1, 11,  9, 13, 11,  7, 14, 17,  9, 11, 13, 21, 13, 17 >