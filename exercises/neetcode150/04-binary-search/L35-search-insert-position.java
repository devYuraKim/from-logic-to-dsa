// leetcode.com/problems/search-insert-position/
// Thu May 28 2026
// 27'42'' + LLM feedback

class Solution {
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            }

            if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        if(nums[left] >= target){
            return left;
        }else{
            return left+1;
        }

    }
}

// [1,3,5,6] 2
// left=0, right=3, mid=1, nums[1]=3 > target=2
// left=0, right=mid-1=0 while(0<0) close
// if(nums[left]=1 < target=2) return left+1;

// [1,3,5,6] 7
// left=0, right=3, mid=1, nums[1]=3 < target=7
// left=mid+1=2, right=3, mid=2, nums[2]=5 < target=7
// left=mid+1=3, right=3 while(3<3) close
// if(nums[left]=5 < target=7) return left+1;

// [1,3,5,6] 0
// left=0, right=3, mid=1, nums[1]=3 > target=0
// left=0, right=mid-1=0 while(0<0) close
// if(nums[left]=1 > target=0) return left;