// Sat May 30 2026
// 7'50''
class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length-1;

        //check
        while (left < right){
            int mid = left + (right-left)/2;

            if(nums[mid] < nums[right]){ //mid부터 nums까지는 오름차순으로 정렬, 가장 작은 값은 mid이므로 right=mid로 mid 포함해서 확인
                right = mid;
            }else{ //nums[mid] >= nums[right] 도중에 푹 꺼지는 곳이 있음, mid는 가장 작은 값이 아니므로 left=mid+1로 mid 제외해서 확인
                left = mid+1;
            }

        }

        return nums[left];

    }
}

// [4,5,6,7]
// left=0, right=3, mid=1
// nums[mid1]=5 nums[right]=7 right=mid=1
// left=0, right=1, mid=0
// nums[mid0]=4, nums[right1]=5 right=mid=0
// left == mid라서 while break

// [4,5,0,1,2,3]
// left=0, right=5, mid=2
// nums[mid2]=0, nums[mid3]=3, right=mid=2
// left=0, right=2, mid=1
// nums[mid1]=5, nums[right2]=0, left=mid+1=2
// left=2, right=2, mid=1
// left == mid라서 while break