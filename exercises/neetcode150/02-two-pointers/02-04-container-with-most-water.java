// Fri May 22 2026
// 12'38''
// 제정신인가... line 17,19에서 heights[left] 안 하고 left 이러고 있었음
// 그러면서 트레이싱하면서 '아니, 돼야 하는데?' 이럼... 미친...

class Solution {
    public int maxArea(int[] heights) {

        int output = 0;

        int left = 0;
        int right = heights.length-1;

        while(left<right){
            int curAmount = Math.min(heights[left], heights[right]) * (right-left);
            if(curAmount > output) output = curAmount;

            if(heights[left]<heights[right]){
                left++;
            }else if(heights[left]>heights[right]){
                right--;
            }else{
                left++;
                right--;
            }
        }

        return output;
    }
}

// 1 < 6
// 7 > 6
// 7 > 3
// 7 > 7
// 2 < 4
// 5 > 4
// 5 < 8
// 12 < 8
// 12 > 7
// 12 < 500
// 3 < 500
// 500 500