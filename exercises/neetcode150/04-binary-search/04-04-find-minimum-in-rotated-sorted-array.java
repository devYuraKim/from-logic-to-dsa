// Thu May 28 2026
// 13'57''
class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length-1;

        while(left<right){
            int mid = left + (right-left)/2;
            //미친... 이걸 이렇게 써놨으니까 안 됐지...
            //if(nums[mid]<right){
            if(nums[mid] < nums[right]){
                right = mid;
            }else{ // nums[mid] >= right
                left = mid+1;
            }
        }

        return nums[left];

    }
}

// left=0, right=5, mid=2
// nums[mid2]=5 > nums[right5]=2, left=mid+1=3
// left=3, right=5, mid=4
// nums[mid4]=1, nums[right5]=2, right=mid=4
// left=3, right=4, mid=3
// nums[mid3]=6, nums[right]=1, left=mid+1
// left=4, right=4, mid=4 (left<right)

// left=0, right=3, mid=1
// nums[mid1]=5 < nums[right3]=7, right=mid=1
// left=0, right=1, mid=0
// nums[mid0]=4 < nums[right]=5, right=mid=0
// left=0, right=0, mid=0