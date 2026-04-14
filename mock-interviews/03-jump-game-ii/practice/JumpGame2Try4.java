public class JumpGame2Try4 {

    public static void main(String[] args){

        int[] example0 = { 2, 3, 1, 1, 4 };
        int[] example1 = { 4, 5, 1, 1, 3, 1, 0, 1 };
        int[] example2 = { 10, 1, 1, 1, 1 };
        int[] example3 = { 2, 3, 0, 0, 4 };

        System.out.println(getMinimumJumps(example0));
        System.out.println(getMinimumJumps(example1));
        System.out.println(getMinimumJumps(example2));
        System.out.println(getMinimumJumps(example3));

    }

    static int getMinimumJumps(int[] nums){

        int jumps = 0;

        int endOfRange = 0;
        int maxReachableIndexOfRange = 0;

        for(int i=0; i < nums.length-1; i++){

            // endOfRange = i + nums[i];

            //각 인덱스에서의 endOfRange와 비교하여 가장 큰 값을 maxIndexOfRange로 업데이트
            //maxReachableIndexOfRange = Math.max(endOfRange, maxReachableIndexOfRange);
            maxReachableIndexOfRange = Math.max(i + nums[i], maxReachableIndexOfRange);

            // 특정 인덱스 범위의 마지막에 도달하면 무조건 점프 해야 함
            // 그리고 해당 구간에서 가장 큰 인덱스 값인 maxIndexOfRange로 endOfRange를 업데이트
            // TODO: 여기 뭔가 명확하지 않음
            if ( i == endOfRange){
                jumps++;
                endOfRange = maxReachableIndexOfRange;
            }

        }

        return jumps;
    }

}

// 이거 왜 잘못된 건지 분석하기
// 잘못1: endOfRange를 line26에서 i+nums[i]로 정의하면 안 되는 이유?
// 잘못2: loop의 기준을 nums.length이 아니라 nums.length-1로 잡아야 하는 이유?