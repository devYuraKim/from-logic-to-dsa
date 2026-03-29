public class PracticeMemoization {

    public static void main(String[] args) {

        System.out.println(fib(10));

    }


    // fib(0) = fib(1) = 1
    // fib(2) = fib(0) + fib(1) = 2
    // fib(3) = fib(1) + fib(2) = 1 + 2 = 3
    // fib(4) = fib(2) + fib(3) = 2 + 3 = 5

    // calculate fib(2) then memo
    // fib(2): 계산 후 저장, fib(2) = 1 + 1 = 2
    // fib(3): 계산 후 저장, fib(3) = fib(1) + fib(2) = 1 + fib(2) 꺼내기 = 1 + 2 = 3
    // fib(4): 계산 후 저장, fib(4) = fib(2) + fib(3) = fib(2) 꺼내기 + fib(3) 꺼내기 = 2 + 3 = 5

    public static int fib(int n){

        int cur;

        // 어떤 DS에 memo를 저장할 것인가?
        // ??? HashMap에 저장해서 n-2, n-1 값 찾을 때 O(1)로 처리 가능하도록
        // ??? Syntax 모름
        <Map>HashMap memo = new HashMap();

        if( n == 0 || n == 1 ) {
            return 1; // 조기 종료
        }

        // ISSUE: dry run 하다가 찾은 거 >> memo가 누적 업데이트가 안 됨
        // SOLUTION: ??? 이런 경우에 어떻게 실마리 찾아야 될지를 모르겠는데, 우선 함수 분할 해야 함, 그리고 loop 돌아야 할 듯?
        // BRAIN STORMING: n == 4, fib(2) 구함 > 저장. fib(3) 구함 > 저장. fib(4) 구함 > 저장.
        // 0부터 n까지 loop 돌아야 할 듯
        // ??? 자 여기서 생각 꼬였다. 어떻게 하지? 왜냐면 난 fib(0) = 1, fib(1) = 1을 저장하고 싶거든, 그런데 n == 0이면 loop이 안 돌아
        for( int i = 0; i =< n; i++ ){
            // n == 0 한 번 돌아, n == 1 두 번 돌아야 하는데 조기 종료로 한 번만 하고 끝, return 구문 빼버림
            if( n == 0 || n == 1 ) {
                memo.add(n, 1); // { {0:1}, {1:1} }
            }

            // n == 2 세 번 돌아
            int prev_prev = memo.find(n-2); //memo.find(0) == 1
            int prev = memo.find(n-1); //memo.find(1) == 1;
            memo.add(n, prev_prev + prev); // { {0:1}, {1:1}, {2:2} }

            // n == 3 네 번 돌아
            // n == 2에서 early return이 되어 버리지 않게 return loop에서 빼버림
            // int prev_prev = memo.find(1) == 1
            // int prev = memo.find(2) == 2
            // memo.add(3, 3); // { {0:1}, {1:1}, {2:2}, {3:3} }
        }


        // original return value: calculate every time
        // return fib(n-2) + fib(n-1);

        // current return value: check loop and pick the latest two
        cur = memo.find(n-1) + memo.find(n-2);
        return cur;

    }

}

// TODO1: PracticeMemoization.java에서 line: 24, 33, 34, 37, 39, 50 정리 (특히 생각 꼬일 때랑, 누적 저장 안 되는 거, 루프 횟수 맞추기에서 오래 걸림).

// 실수1. Loop: i <= n, not i =< n
// 실수2. HashMap 선언 문법: Map<Integer, Integer> memo = new HashMap<>();
// 실수3. HashMap 값 구하기: memo.put(key, value);, memo.get(key)