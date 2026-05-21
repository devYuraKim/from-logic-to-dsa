// Thu May 21 2026
// 36'13'' + LLM feedback
// left, right 모두 활용하는 기존 접근법으로 풀이
// 단, left=mid+1, right=mid, else 조건 붙어야 하는 이유 세 가지 정리 필요
class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int mid = (left+right)/2;
            if(nums[mid] > nums[right]){
                // 역순 발생!
                // mid-right 사이에 최소값 존재하므로 left-mid 버림
                left=mid+1; // mid는 최소값이 아니므로 제외
                //left=mid;
            }else if(nums[mid] < nums[left]){
                // 역순 발생!
                // left-mid 사이에 최소값 존재하므로 right-mid 버림
                right=mid;
            }else{
                return nums[left];
            }
            // }else if(left==mid || right==mid){
            //     left++;
            //     right--;
            // }else if(left == mid && right == mid){
            //     return left;
            // }
        }

        return nums[left];

    }
}

// (0,1,2,3,4,5)
// [4,5,0,1,2,3]

//(1)
//left=0, right=5, mid=2
//[0]=4, [2]=0, [5]=3
//left > mid < right
//(2)
//left=0, right=2, mid=1
//[0]=4, [1]=5, [2]=0
//left < mid > right
//left=mid=1, right=2, mid=1
//[1]=5, [1]=5, [2]=0
//


// left=0, right=5, mid=2
// nums[left]=4, nums[mid]=0, nums[right]=3
// nums[left]>nums[mid]이므로 left=mid
// left=2, right=5, mid=3
// nums[left]=0, nums[mid]=1, nums[right]=3
// left=3, right=4, mid=3
// nums[left]=1, nums[mid]=1, nums[right]=2



// left=1, right=4, mid=2
// nums[left]=5, nums[mid]=0, nums[right]=2
// left=2, right=3, mid=2
// nums[left]=



// (0,1,2,3,4,5)
// [3,4,5,6,1,2]

// left=0, right=5, mid=2
// nums[left]=3, nums[mid]=5, nums[right]=2
// mid > right이므로 left = mid+1
// left=3, right=5, mid=4
// nums[left]=6, nums[mid]=1, nums[right]=2
// ***alert*** mid < left
// left++, right--
// left=4, right=4, mid=4