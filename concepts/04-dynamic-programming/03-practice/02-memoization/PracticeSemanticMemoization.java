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