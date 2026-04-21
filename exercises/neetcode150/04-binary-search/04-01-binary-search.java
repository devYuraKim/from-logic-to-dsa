// approach1. infinite loop

class Solution {
    public int search(int[] nums, int target) {

        // ( 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 )
        // [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ]

        // target == 3
        // startIndex (0 -> halfIndex4 -> 0 -> halfIndex1 -> 2)
        // endIndex (9 -> halfIndex4 -> 3 -> halfIndex1 -> -)

        // target == 9
        // startIndex (0 -> halfIndex 4 -> 5 -> halfIndex7 -> 8)
        // endIndex (9 -> halfIndex 4 -> 9 -> halfIndex7 -> -)

        // target이 더 작으면 endIndex가 움직이고 (halfIndex-1)로
        // target이 더 크면 startIndex가 움직이고 (halfIndex+1)로

        int startIndex = 0;
        int endIndex = nums.length - 1;

        int halfIndex = (startIndex+endIndex)/2; //java는 버리는 거였지...?

        while (target != nums[halfIndex]){
            if(target < nums[halfIndex]){
                // startIndex 고정
                endIndex = halfIndex - 1;
            }else if(target > nums[halfIndex]){
                // endIndex 고정
                startIndex = halfIndex + 1;
            }else {
                return halfIndex;
            }
        }

        return -1;

    }
}


// approach2.

class Solution {
    public int search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        // 탐색 범위가 유효할 때까지만 반복
        while (startIndex <= endIndex) {
            // 반복마다 중앙 인덱스를 새로 갱신
            int halfIndex = startIndex + (endIndex - startIndex) / 2;

            if (nums[halfIndex] == target) {
                return halfIndex;
            } else if (nums[halfIndex] > target) {
                endIndex = halfIndex - 1;
            } else {
                startIndex = halfIndex + 1;
            }
        }

        // 반복문이 종료될 때까지 찾지 못하면 -1 반환
        return -1;
    }
}