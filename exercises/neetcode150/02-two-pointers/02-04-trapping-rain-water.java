// Thu May 21 2026
// 43'07'' + LLM feedback
class Solution {
    public int trap(int[] height) {

        int output = 0;

        int left = 0;
        int right = height.length-1;

        int leftMax = height[0];
        int rightMax = height[height.length-1];

        while(left < right){
            // 오른쪽 벽이 버티고 있음
            if(leftMax < rightMax){
                // 왼쪽 포인터 전진(초기값 탈피)
                left++;
                // 왼쪽 벽이 더 높아지면 물이 고일 수 없음. 최댓값 업데이트
                if(leftMax < height[left]){
                    leftMax = height[left];
                    // 왼쪽 벽이 더 낮아지면 (최댓값-현재값)만큼 물 고일 수 있음
                }else{
                    output += leftMax - height[left];
                }
                // 왼쪽 벽이 버티고 있음
            }else{
                // 오른쪽 포인터 전진(초기값 탈피)
                right--;
                // 오른쪽 벽이 더 높아지면 물이 고일 수 없음. 최댓값 업데이트
                if(rightMax < height[right]){
                    rightMax = height[right];
                    // 오른쪽 벽이 낮아지면 (최댓값-현재값)만큼 물이 고일 수 있음
                }else{
                    output += rightMax - height[right];
                }
            }
        }

        return output;

    }
}