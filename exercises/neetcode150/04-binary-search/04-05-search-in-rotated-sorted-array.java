// Sat May 30 2026
// 29'53'' + LLM feedback
class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        // ####오류1####
        while(left <= right){
            //while(left<right){
            int mid = left + (right-left)/2;

            if(nums[mid]==target){
                return mid;
            }

            // ####오류2####
            if(nums[mid] <= nums[right]){
                //if(nums[mid] < nums[right]){ //mid부터 right까지 ascending order
                // target은 mid보다 작거나, right보다 큰 경우 -> mid부터 right에 존재하지 않음 -> mid-right 날림 = right=mid-1
                if(target < nums[mid] || target > nums[right]){
                    right = mid-1;
                    // target이 mid보다 크거나(같은 경우는 위에서 handle), right보다 같거나 작은 경우 -> left-mid 날림 -> left=mid+1
                }else{ // target >= mid && target <= nums[right]
                    left = mid+1;
                }
            }else{ //left부터 mid까지 ascending order (mid부터 right 중에 dip이 존재함) [3,4,5,0,1,2]
                // target이 left보다 작거나, mid보다 큰 경우 -> left부터 mid에 존재하지 않음 -> left-mid 날림 -> left=mid+1
                if(target < nums[left] || target > nums[mid]){
                    left=mid+1;
                    // target이 left보다 같거나 크거나, mid보다 작은 경우(같은 경우는 위에서 handle) -> mid-right 날림 -> right=mid-1;
                }else{ // target>=nums[left] && target <= nums[mid]
                    right=mid-1;
                }
            }
        }

        return -1;

    }
}

// [4,5,6,7,0,1,2] target=0
// left=0, right=6, mid=3
// nums[mid3]=7 > nums[right6]=2 -> target=0 < nums[left0]=4, < nums[mid3]=7 -> left=mid+1=4
// left=4, right=6, mid=5
// nums[mid5]=1 < nums[right6]=2 -> target=0 < nums[mid5]=1, < nums[right6]=2 -> left=mid+1=6
// left=6 right=6 (while break) return -1

// [3,5,6,0,1,2] target=4
// left=0, right=5, mid=2
// nums[mid2] = 6 > nums[right5]=2 -> target=4 > nums[mid2]=6 -> left=mid+1=3
// left=3, right=5, mid=4
// nums[mid4] = 1 < nums[right5]=2 -> target=4 < nums[right5]2 -> left=mid+1 = 5
// left=5, right=5 (while break) return -1