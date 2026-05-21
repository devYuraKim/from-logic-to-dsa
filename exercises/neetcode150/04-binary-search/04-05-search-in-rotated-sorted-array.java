// Thu May 21 2026
// 23'19''
// 감으로 풀고 보니 최악의 경우 brute force가 되는 binary search 혼혈이라서 결국 시간복잡도 O(n)이다... 순수 binary로 다시 해 볼 것
class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        int output = -1;

        while(left<=right){

            //tip: overflow 방지 수식 확인할 것
            int mid = (left+right)/2;

            if(nums[left]==target){
                //output = left;
                return left;
            }else if (nums[mid]==target){
                //output = mid;
                return mid;
            }else if (nums[right]==target){
                //output = right;
                return right;
            }else if(nums[left] < nums[mid] && nums[left] > target){
                left = mid+1;
            }else if(nums[right] < nums[mid] && nums[mid] > target){
                right = mid-1;
            }else{
                left++;
                right--;
            }

        }

        return output;
        // left=0, right=nums.length-1, mid=(left+right)/2

        // target==1
        // (1)
        // left=0, right=5, mid=2
        // [0]=3, [2]=5, [5]=2
        // left부터 mid까지는 가망 없음 > left=mid+1로 바꿈
        // (2)
        // left=3, right=5, mid=4
        // left[3]=6, mid[4]=1, right[5]=2

        // target=4
        // (1)
        // left=0, right=5, mid=2
        // left[0]=3, mid[2]=6, right[5]=2
        // mid부터 right까지는 가망 없음 > right=mid-1로 바꿈
        // left=0, right=1, mid=0
        // left[0]=3, mid[0]=3, right[1]=5
        // 없음

    }
}
