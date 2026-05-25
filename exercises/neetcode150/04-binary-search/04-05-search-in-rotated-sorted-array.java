// Tue May 26 2026
// 56'16'' + LLM Feedback
// Binary Search의 기본 구조는 '확실히 정답이 없는 절반을 날린다'
class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;

            if(nums[mid]==target){
                return mid;
            }

            //binary search -> remove half where target can't be
            if(nums[mid]<nums[right]){ //ascending order maintained from mid to right [6,7(target),0,1(mid),2,4,5(right)]
                // if(nums[mid]<target){ //0부터 left까지는 target 없음이 확실 [4]<[7]
                //     left=mid+1; //mid+1부터 right까지 검색
                // }else if(nums[mid]>target){ //mid부터 right까지는 target이 없음이 확실
                //     right=mid-1;
                // }

                // if(target > nums[right]){ //target은 mid부터 right까지에 없음. 즉, left부터 mid-1에 있음
                //     right=mid-1;
                // }else if(nums[mid] < target && target <= nums[right]){
                //     left=mid+1;
                // }

                if(nums[mid]<target && target <= nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else{
                // }else if(nums[mid] > nums[right]){ //asending order maintained from left to mid [3(left),4,5,6(mid),7,0,1,2(right)]
                // if(nums[mid] > target){ //left부터 mid 사이에 있음???
                //     right=mid-1;
                // }else if(nums[mid]<target){
                //     left=mid+1;
                // }

                // if(nums[mid] > target && target >= nums[left]){
                //     right=mid-1;
                // }else if(nums[mid] < target){
                //     left=mid+1;
                // }

                if(nums[mid] > target && target >= nums[left]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }

            }
        }

        return -1;
    }
}
