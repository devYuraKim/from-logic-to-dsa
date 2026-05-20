// Thu May 21 2026
// 1:00:32 + LLM feedback

class Solution {
    public int largestRectangleArea(int[] heights) {

        int maxArea = 0;

        for(int i=0; i<heights.length; i++){

            int left = i-1;
            int right = i+1;

            int h = heights[i];

            while(left >=0 && left < i){
                if(h <= heights[left]){
                    left--;
                }else{
                    break;
                }
            }

            while(right < heights.length && right > i){
                if(h <= heights[right]){
                    right++;
                }else{
                    break;
                }
            }

            int area = h*(right-left-1);
            if(area > maxArea){
                maxArea = area;
            }

        }

        return maxArea;

    }
}

// Input: heights = [7,1,7,2,2,4]

// heights[0]
// heights[i+1] < heights[i]
// width = heights[0]

// heights[1]
// heights[i-1] <= heights[i] leftIndex = 0,
// heights[i] <= heights[i+1] [i+2] ... [heights.length-1] rightIndex = heights.length-1
// width = heights[1] * (rightIndex - leftIndex + 1)

// heights[2]
// heights[i-1] < heights[i]
// heights[i+1] < heights[i]
// width = heights[2]

// heights[3]
// heights[i-2] <= heights[i]
// heights[i-1] > heights[i] leftIndex = i-1
// heights[i] <= heights[i+1] ... [heights.length-1] rightIndex = heights.length-1
// width = heights[3] * (rightIndex - leftIndex + 1)