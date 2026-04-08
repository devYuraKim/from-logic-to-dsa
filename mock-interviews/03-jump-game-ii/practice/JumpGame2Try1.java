public class JumpGame2Try1 {

    public static void main (String[] args) {

    }


}


// 1. 배열의 마지막 인덱스에 절대적으로 가까운 원소로 이동하는 것이 유리한가?
// 2. 범위에 있는 원소 중 가장 많은 점프를 할 수 있는 원소로 이동하는 것이 유리한가?
// => 구님: ‘해당 범위에서 다음에는 어디까지 갈 수 있는가‘를 생각해보라고 했던 것 같은데

// Input: nums = [2,3,1,1,4]

// index[0] 시작:
    // 이동 가능한 인덱스 범위 index[0]-index[2]
    // [2,3,1] 중에 선택 가능
    // max_index = 2

// index[1]에 있으면:
    // 이동 가능한 인덱스 범위 index[1]-index[4]
    // [3,1,1,4] 중에 선택 가능
    // max_index = 4

// index[2]에 있으면:
    // 이동 가능한 인덱스 범위 index[2]-index[3]

// index[3]에 있으면:
    // 이동 가능한 인덱스 범위 index[3]-index[4]

// index[4]에 있으면
    // 이동 가능한 인덱스 범위 index[4]

// 일반화해볼까
// index i에 있으면 ( 0 <= i <= n-1 )
// 이동 가능한 인덱스 범위 index i 부터 index (i + nums[i])
// *** 이때 i + nums[i] 범위를 어떻게 관리해야하는지는 잘 모르겠음 그런데 관리 해야 할 것 같기는 함
// 이때 관리해야 하는 값은 (i + nums[i])가 (n-1) == (nums.length)의 "차이"가 최소가 되는 녀석을 골라야 함

// 다시 말해서,
// index 0에서 index 0, 1, 2의 값을 검토
// nums[0] == 2, nums[1] == 3, nums[2] == 1
// index 0 선택 시, 가능 범위 index 0 - index (0+2), 2 <= 4 true
// index 1 선택 시, 가능 범위 index 1 - index (1+3), 4 <= 4 true
// index 2 선택 시, 가능 범위 index 2 - index (2+1), 3 <= 4 true
// then,
// choosing index 1 returns the biggest index
// from index 0 to index 1 (jump 1)
// from index 1 to index 4 (jump 2)

// my question is,
// do we need to go over all the options?



// 면접관이 제시한 다른 예시 돌려보자


// ex1. [4, 5, 1, 1, 3]
// n == 5
// at index 0: available range index 0 - index (0+4), 4 <= 5 true
    // choosing index 0: avaialble range index 0 - index (0+4), 4 <= 5 true
    // choosing index 1: available range index 1 - index (1+5), 6 <= 5 false
    // choosing index 2: available range index 2 - index (2+1), 3 <= 5 true
    // choosing index 3: available range index 3 - index (3+1), 4 <= 5 true
    // choosing index 4: available range index 4 - index (4+3), 7 <= 5 false
// from index 0 to index 1: jump1
// from index 1 to index 4: jump2
// minimum jumps count == 2

// my hunch:
// if any of the 'index overflow check' returns 'false', you just go with it


// ex2. [4, 99, 1, 1, 3, 1, 0, 1]
// applying my hunch
// n == 8
// at index 0, available index range: 0 - (0+4), 4 <= 8 true
// at index 1, available index range: 1 - (1+99), 100 <= 8 false
// so here, we drop the loop and choose index 1

// from index 0 to index 1: jump 1
// from index 1 to index 7: jump 2
// minimum jumps counts == 2