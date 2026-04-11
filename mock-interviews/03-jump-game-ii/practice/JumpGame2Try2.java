import java.util.ArrayList;
import java.util.List;

// 뭔가 try1보다 logic이 더 polished된 것 같은데, 이 아래 두 경우를 어떻게 코드로 처리해야하는지 모르겠음
// [issue1] 'nums' 전체 loop을 돌지 않고, 현재 index 0에서 갈 수 있는 범위 index만 돌고 있음
// [issue2] 어떻게 다른 index 간의 distance를 비교해서, 어느 시점에서 index와 jumps를 업데이트해야 하는지 모르겠음
public class JumpGame2Try2 {

    public static void main (String[] args) {
        int[] nums = { 2, 3, 1, 1, 4};
        getMinJumps(nums);
    }

    public static int getMinJumps(int[] nums) {

        // state, let's think what kind of "STATES" I need to manage

        // 1. (the goal) number of jumps
        int jumps = 0;
        // 2. (the goal) the last(target) index
        int TARGET_INDEX = nums.length - 1;
        // 3. (temporary data saving something)
        // List<Integer> distances = new ArrayList<>();
        // 생각해보니까 이게 필요가 없겠다

        int minimumDistanceIndex = 0;
        // 이걸 외부에서 관리할 때 초기값을 어떻게 설정해야 좋을까?
        // 처음에는 Index 0부터 시작하니까 0부터 targetIndex까지의 거리로 초기화
        int prevDistance = TARGET_INDEX;
        int curDistance = prevDistance;

        // start at index 0, check index range
        int maxIndexAtIndex0 = 0 + nums[0];

        // @@@@@ dry run하면서 찾은 issue 1: 'nums' 전체 index를 loop하지 않고 있음 >> correction needed

        // for that given index range, 0 - 0 + nums[0]
        // check each index's max index
        // add it to an array
        for(int i = 0; i <= maxIndexAtIndex0; i++){
            int maxIndexAtIndexI = i + nums[i];
            // i==0일 때, maxIndexAtIndex0 = 0 + 2 = 2
            // i==1일 때, maxIndexAtIndex1 = 1 + 3 = 4

            // check the distance between 'the target index' and 'max index at index i'
            int distanceAtIndexI = TARGET_INDEX - maxIndexAtIndexI;
            // targetIndex==4
            // i==0일 때, distanceAtIndex0 = 4 - 2 = 2
            // i==1일 때, distanceAtIndex1 = 4 - 4 = 0
            if(distanceAtIndexI <= 0) {
                // i==1일 때, jumps=1
                jumps++;
                return jumps+1;
            } else {
                // list up the differences
                // ArrayList로 만들어서 length가 변경 가능하도록 만들어야 할 것 같다
                // distances.add(i, distanceAtIndexI);
                // for loop 끝나면 distances에서 max 값 뽑아서 그 index로 이동

                // 갑자기 이 생각났음.. 그 정보를 다 관리할 필요 없잖아...?
                // minimum distance 갖는 index 정보만 내가 관리하면 되는 거잖아?
                // 그런데 저 loop에서 i가 바뀔 때 값 비교는 어떻게 하는 게 좋을까?
                // loop 외부에서 관리해서 업데이트 되게 하는 게 맞지 않나?

                // 분기 기준 따져보자: it shouldn't be the same, because we have handled that case in the above if condition. Right?
                // if(distanceAtIndexI < currentDistance){
                //    minimumDistanceIndex = i; // i==0일 때, minimumDistanceIndex = 0
                //    currentDistance = distanceAtIndexI; // i==0일 때, currentDistance = 2
                // 여기서 jumps++ 시점을 어디로 잡아야 하는지 헷갈림
                // 자 그러면 dry run을 해보자
                //}

                // 일단 기록해두자, currentDistance가 얼마인지
                curDistance = distanceAtIndexI; // i==0일 때, currentDistance는 2
                // 그러면 이거 비교는 어떻게 함?ㅋㅋ 미쳐버려...
                // 이거 둘이 같을 때는?ㅋㅋ Math.min 이거 어떻게 쓰는 거임?
                // if(Math.min(prevDistance, curDistance) == curDistance){
                //     minimumDistanceIndex = i;
                //  } else {
                //     minimumDistanceIndex = i-1;
                // }
                if(curDistance < prevDistance){
                    minimumDistanceIndex = i;
                    // i==0일 때, curDistance==2, prevDistance==4이므로, minimumDistanceIndex = 0;
                }
                // 이거 필요 없는 것 같은데, 그냥 업데이트만 하면 되는 거니까?
                // else {
                //    minimumDistanceIndex = i-1;
                // }
            }
        }

        // if not possible
        return -1;
    }

}