// LeetCode70 Climbing Stairs
// 20:35 - 20:54
public class PracticeClimbingStairs1 {

    public static void main (String[] args) {

        System.out.println(countWays(1));
        System.out.println(countWays(45));

    }

    //constraint: 1<=n<=45

    public static int countWays(int n){

        // [start - revised code]
        return n / 2 + 1;
        // [end - revised code]

        // [start - original code]
        // if( n % 2 == 0 ) {
        //     return ( n / 2 + 1) ;
        // } return ( n / 2 );
        // [end - original code]


        // combination (either take 1 or take 2)
        // n = 4
        // 1. 1 + 1 + 1 + 1 = 4
        // 2. 1 + 1 + 2 = 4
        // 3. 2 + 2 = 4

        // 내 생각 정리
        // 일단 n에서 1을 x번 빼고, 2를 y번 빼서 0이 되어야 함.
        // ??? '조합'의 수를 어떻게 계산하지?

        // !!! n == 짝수 2k, 홀수 2k+1이기 때문에 홀수는 1이 무조건 하나가 들어감
        // 그런데 위의 내용이 '가지수' 구하는 거랑 무슨 상관이 있음?

        // (내가 여기서 무슨 감을 못 잡고 있는 걸까?)
        // 자, 짝수 2k는 2로만 만들려면 2가 k개 있으면 됨.
        // 자, 짝수 2k는 1로만 만들려면 1이 2k개 있으면 됨.
        // 그러면 (2가 k개, 1이 0개) 있는 경우의 수부터 (2가 0개, 1이 2k개) 있는 경우의 수

        // n == 2k일 때,
        // n == 2라면, (2가 1개, 1이 0개), (2가 0개, 1이 2개) 두 경우
        // n == 4라면, (2가 2개, 1이 0개), (2가 1개, 1이 2개), (2가 0개, 1이 4개) 세 경우
        // n == 6이라면, (2가 3개, 1이 0개), (2가 2개, 1이 2개), (2가 1개, 1이 4개), (2가 0개, 1이 6개) 네 경우
        // 규칙 나왔다: if( n % 2 == 0 ) return (n / 2 + 1) ;

        // n == 2k+1일 때,
        // n == 1이라면, (2가 0개, 1이 1개) 한 경우
        // n == 3이라면, (2가 1개, 1이 1개), (2가 0개, 1이 3개) 두 경우
        // n == 5라면, (2가 2개, 1이 1개), (2가 1개, 1이 3개), (2가 0개, 1이 5개) 세 경우
        // 규칙 나왔다: if( n % 2 != 0 ) return (n / 2);
        // 왜냐면 int는 올림 >>>> 이거 틀렸음. Refer to [실수3]

    }

}

// 실수1. 문제에 'distinct ways'라고 되어 있잖아... permutation이다
// 실수2. n이 1부터 45잖아... 눈치 챙겨라... 딱 봐도 int 자료형 범위 안 넘어가게 45까지 준 거잖냐
// 실수3. JAVA에서 나눗셈은 '버림' 후 정수다

// 오류1. 이건 조합(combination)도 아니고 그냥 정수 분할(Integer Partition)임.
//       개심각하다... 모교 졸업장 반납해야겠다...