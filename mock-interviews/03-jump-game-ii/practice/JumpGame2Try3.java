public class JumpGame2Try3 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        getMinJumps(nums);

        int[] nums2 = {4, 5, 1, 1, 3, 1, 0, 1};
        getMinJumps(nums2);

    }

    public static int getMinJumps(int[] nums) {

        int jumps = 0;
        int maxIndexAtI = 0;
        int currentMaxIndex = 0;

        for(int i = 0; i < nums.length; i++){
            maxIndexAtI = i +  nums[i];
            // i==0, maxIndexAtI=0+2=2
            // i==1, maxIndexAtI=1+3=4

            // i==0, maxIndexAtI=0+4=4
            // i==1, maxIndexAtI=1+5=6
            // i==2, maxIndexAtI=2+1=3
            // i==3, maxIndexAtI=3+1=4
            // i==4, maxIndexAtI=4+3=7

            if(maxIndexAtI >= nums.length-1){
                jumps++;
                return;
            }
            // i==1, return jumps=2

            // i==4, return jumps=3

            if(maxIndexAtI > currentMaxIndex){
                currentMaxIndex = maxIndexAtI;
                jumps++;
            }
            // i==0 currentMaxIndex=2 jumps=1

            // i==0 currentMaxIndex=4 jumps=1
            // i==0 currentMaxIndex=6 jumps=2
        }

        return jumps;

    }

}