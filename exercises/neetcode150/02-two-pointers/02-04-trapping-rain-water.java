// Thu May 21 2026
// 24'02'' + LLM feedback
// '여기 기준에서 왼쪽으로 가장 높은 벽은? 여길 기준으로 오른쪽으로 가장 높은 벽은?'
// LLM으로 while문, for loop, height[index] 오류 잡음
class Solution {
    public int trap(int[] height) {

        int output = 0;

        for(int i=1; i<height.length-1; i++){
            //for(int i=1; i<height.length-2; i++){

            //int left = i-1;
            //int right = height.length-1;

            //i==1, leftMax=0, height[i]=2, rightMax=3
            //i==2, leftMax=2, height[i]=0, rightMax=3 --> output += Math.min(leftMax, rightMax)-height[i] = 2
            //i==3, leftMax=2, height[i]=3, rightMax=3
            //i==4, leftMax=3, height[i]=1, rightMax=3 --> output += Math.min(leftMax, rightMax)-height[i] = 2
            //i==5, leftMax=3, height[i]=0, rightMax=3 --> output += Math.min(leftMax, rightMax)-height[i] = 3
            //i==6, leftMax=3, height[i]=1, rightMax=3 --> output += Math.min(leftMax, rightMax)-height[i] = 2
            //i==7, leftMax=3, height[i]=3, rightMax=2
            //i==8, leftMax=3, height[i]=2, rightMax=1

            // height[i]가 leftMax, rightMax 둘보다 같거나 크면 스킵
            // height[i]가 leftMax, rightMax 둘보다 작으면 output += Math.min(leftMax, rightMax)-height[i] = 2

            int leftMax=height[0];
            int rightMax=height[height.length-1];

            // 왼쪽에서 max랑 오른쪽에서 max를 어떻게 찾지?
            //while(left < i && i < right){
            for(int j=0; j<=i-1; j++){
                //for(int j=0; j<=left; j++){
                if(leftMax < height[j]){
                    leftMax = height[j];
                }
                //if(leftMax < height[left]){
                //    leftMax = height[left]
                //}
            }
            for(int k=i+1; k<height.length; k++){
                //for(int k=height.length-1; k>=right; k--){
                if(rightMax < height[k]){
                    rightMax = height[k];
                }
                //if(rightMax < height[right]){
                //    rightMax = height[right]
                //}
            }
            //}

            if(height[i] >= leftMax && height[i] >= rightMax){
                //if(height[i] >= height[leftMax] && height[i] >= height[rightMax]){
                continue;
            }
            if(height[i] < leftMax && height[i] < rightMax){
                //if(height[i] < height[leftMax] && height[i] < height[rightMax]){
                output += Math.min(leftMax, rightMax)-height[i];
            }
        }

        return output;
    }
}