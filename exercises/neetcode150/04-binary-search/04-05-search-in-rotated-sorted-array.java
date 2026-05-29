// Fri May 29 2026
// 43'32'' + LLM Feedback
class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left + (right-left)/2;

            if(nums[mid]==target){
                return mid;
            }

            if(nums[mid]<nums[right]){ //오름차순 배열
                if(target < nums[mid] || target > nums[right]){ //target can't be between [mid] and [right]
                    right = mid-1;
                }else{ // target > nums[mid] || target < nums[right]
                    // [1,2,3,4,5,6] target=5
                    // left=0, right=5, mid=2
                    // nums[mid2]=3, nums[right]=6 target=5
                    left = mid+1;
                }
            }else{ // nums[mid]>nums[right] 중간에 푹 꺼지는 부분 존재 -> nums[left]부터 nums[mid]까지는 오름차순 배열
                // [3,4,5,6,0,1,2] target=4
                // left=0, right=6, mid=3
                // nums[mid3]=6, nums[right6]=2
                if(target >= nums[left] && target < nums[mid]){
                    right= mid-1;
                }else { //target <= nums[left] && target > [mid] -> target은 nums[left]부터 nums[mid]까지는 없음
                    left = mid+1;
                }
            }
        }

        return -1;

    }
}

// [1] target = 2
// left=0, right=0, mid=0
// nums[mid]=nums[right]=1 < target=2
// left=mid+1=1???


// [4,5,6,7,0,1,2] target=0
// left=0, right=6, mid=3
// nums[mid3]=7 > nums[right6]=2 < target=0 left=mid+1
// left=4, right=6, mid=5
// nums[mid5]=1 < nums[right6]=2, target=0<nums[mid]=1 right=mid-1;
// left=4, right=4, mid=4

// need to find the exact value -> left<=right ???
// [3,4,5,6,1,2] target=1
// left=0, right=5, mid=2
// nums[mid2]=5 > nums[right5]=2 -> 중간에 푹 꺼지는 부분 존재: target < nums[right]: left=mid+1=3
// left=3, right=5, mid=4
// nums[mid4]=1

// [3,5,6,0,1,2] target=4
// left=0, right=5, mid=2
// nums[mid2]=6 > nums[right]=2 -> 중간에 푹 꺼지는 부분 존재: target > nums[right]: right=mid
// left=0, right=2, mid=1
// nums[mid1]=5 < nums[right2]=6 -> 오름차순 배열: target < nums[mid]: right=mid-1
// left=0, right=0, mid=0
// nums[mid0] = 3