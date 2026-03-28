//Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because the return value of "java.util.Map.get(Object)" is null

import java.util.HashMap;
import java.util.Map;

public class CorrectionSyntaxMemoization {

    public static void main(String[] args) {

        System.out.println(fib(10));

    }


    public static int fib(int n){

        int cur;
        Map<Integer, Integer> memo = new HashMap<>();

        if( n == 0 || n == 1 ) {
            return 1;
        }

        for( int i = 0; i <= n; i++ ){
            if( n == 0 || n == 1 ) {
                memo.put(n, 1);
            }


            int prev_prev = memo.get(n-2);
            int prev = memo.get(n-1);
            memo.put(n, prev_prev + prev);

        }

        cur = memo.get(n-1) + memo.get(n-2);
        return cur;

    }

}