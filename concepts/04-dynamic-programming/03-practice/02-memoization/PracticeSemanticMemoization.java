import java.util.HashMap;
import java.util.Map;

public class PracticeSemanticMemoization {

    public static void main(String[] args) {
        System.out.println(fib(10));
    }


    public static int fib(int n){

        Map<Integer, Integer> memo = new HashMap<>();
        int cur;

        if( n == 0 || n == 1 ) {
            return 1;
        }

        for( int i = 0; i <= n; i++ ){
            if( i == 0 || i == 1 ) {
                memo.put(i, 1);
            } else {
                int prev_prev = memo.get(i - 2);
                int prev = memo.get(i - 1);
                memo.put(i, prev_prev + prev);
            }
        }

        cur = memo.get(n-1) + memo.get(n-2);
        return cur;

    }

}

// 실수1: int prev_prev = memo.get(i - 2);는 auto unboxing 됨...
// 실수2: for loop 내의 if 분기에서 i가 아니라 n을 넣고 있었음...

// TODO1: Mar28 PracticeSemanticMemoization에서 고칠 부분 확인해서 CorrectionSementicMemoization 생성
// TODO2: Syntax, Semantic 틀린 내용 일괄 .md로 정리
// TODO3: java 파일 쉽게 돌릴 수 있는 방법 확인. 매번 javac .java > java 하기가 번거로움
// >>>>> JDK 11 이상인 경우, 그냥 'java 파일명.java'

// SEMANTIC ERROR
// 오류1: 불필요한 이중 계산. 루프가 끝난 시점에 memo.get(n)에 최종값이 존재. 그런데 루프 밖에서 굳이 다시 memo.get(n-1) + memo.get(n-2)를 수행.
// 오류2: 메모이제이션의 본질 실종. 메모이제이션은 "이미 계산한 건 다시 하지 말자". 그런데 여기서는 함수가 호출될 때마다 new HashMap<>()을 생성하고 0부터 다시 계산.
// 오류3: 부적절한 자료 구조.

// 1차 수정 (오류1)
public class PracticeSemanticMemoization {

    public static void main(String[] args) {
        System.out.println(fib(10));
    }


    public static int fib(int n){

        Map<Integer, Integer> memo = new HashMap<>();
        // int cur;

        if( n == 0 || n == 1 ) {
            return 1;
        }

        for( int i = 0; i <= n; i++ ){
            if( i == 0 || i == 1 ) {
                memo.put(i, 1);
            } else {
                int prev_prev = memo.get(i - 2);
                int prev = memo.get(i - 1);
                memo.put(i, prev_prev + prev);
            }
        }

        // cur = memo.get(n-1) + memo.get(n-2);
        // return cur;
        return memo.get(n);

    }

}

// 2차 수정 (오류2)
public class PracticeSemanticMemoization {

    // [scope 변환] memo는 프로그램이 종료될 때까지 초기화되지 않고 유지
    private static Map<Integer, Integer> memo = new HashMap<>();


    public static void main(String[] args) {

        System.out.println(fib(10));
        System.out.println(fib(15));
        System.out.println(fib(20));
    }


    public static int fib(int n){

        if (n <= 1) return 1;

        // [로직 추가] 이미 계산된 적이 있다면 루프를 돌지 않고 즉시 반환 (기억력 장착)
        if (memo.containsKey(n)) return memo.get(n);

        // [로직 추가] 초기값 세팅
        memo.put(0, 1);
        memo.put(1, 1);

        // [scope 변환] i=2부터 수행
        for( int i = 2; i <= n; i++ ){
            if (!memo.containsKey(i)) {
                int val = memo.get(i - 2) + memo.get(i - 1);
                memo.put(i, val);
            }
        }

        // cur = memo.get(n-1) + memo.get(n-2);
        // return cur;
        return memo.get(n);

    }

}

// 3차 수정 (오류3)
public class PracticeSemanticMemoization {

    private static int[] memo = new int[0];

    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(fib(15));
        System.out.println(fib(20));
    }

    public static int fib(int n) {
        // [Guard Clause]
        if (n <= 1) return 1;

        // 안전 장치: 요청한 n이 현재 배열 크기보다 크면 배열을 새로 확장
        if (n >= memo.length) {
            int[] newMemo = new int[n + 1];
            System.arraycopy(memo, 0, newMemo, 0, memo.length);
            memo = newMemo;
            memo[0] = 1;
            memo[1] = 1;
        }

        // 이미 계산된 값이 배열에 있다면 즉시 반환
        // int 배열의 초기값은 0이므로, 0이 아니면 계산된 것으로 간주
        if (memo[n] != 0) return memo[n];

        // [Variable & Boundary] i=2부터 n까지 좌표 일치
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 2] + memo[i - 1];
        }

        return memo[n];
    }
}