//12'37''
class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] output = new int[nums.length];

        int prefix = 1;
        int suffix = 1;

        for(int i=0; i<nums.length; i++){
            output[i] = prefix;
            prefix *= nums[i];
        }

        for(int j=nums.length-1; j>=0; j--){
            output[j] *= suffix;
            suffix *= nums[j];
        }

        return output;

    }
}
