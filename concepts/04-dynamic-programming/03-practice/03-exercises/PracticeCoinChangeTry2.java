//Tue Apr 7 2026
//12:27

public class PracticeCoinChangeTry2 {

    public static void main (String[] args) {

        System.out.println(getCoinChange([1,2,5], 11));
        System.out.println(getCoinChange([2], 3));
        System.out.println(getCoinChange([1], 0));

    }

    public static int getCoinChange(int[] coins, int amount){

        return fewestNumberOfCoins;
    }

}

// pseudocode

// 12:27
// OK let's get going. So I'm going to try applying DP concept I picked up yesterday.

// dp[0]
// We'll start from `dp[0]` and what matters is the 'definition of dp[0]' it would be: the fewest number of coins needed to make up the amount of 0 dp[0] would be 0

// dp[1]
// then we will have `dp[1]` say we're working with example1 where `int[] coins = {1,2,5}`
// here, we will have to go in a loop of the array and check if `dp[1]` is possible.
// fortunately, `dp[1]` (the fewest number of coins needed to make up the amount of 1) would be using element {1} and dp[1] = 1;

// dp[2]
// `dp[2]` can be defined as...
// 12:33
// ok I'm lost here because dp[2] should dp[1] + if it is possible to make dp[2]
// then we will have to check if dp[2] is possible with `int[] coins = {1,2,5}`
// with {1}, dp[2] would be 2
// with {2}, dp[2] would be 1
// so dp[2] = 1;

// so far, dp[0]=0, dp[1]=1, dp[2]=1
// now, dp[3] would be...
// 12:36
// not clear again. dp[3] would be what? how can you make up dp[3]?
// does it make sense to do `dp[1] + dp[2]`? or am I just trying to make it work without any sense?
// 12:38
// let's get back to definition: dp[3] means 'the fewest number of coins needed to make up `amount=3`'
// would adding up 'the fewest number of coins to make up amount=1' and 'the fewest number of coins to make up amount=2' make sense? or it doesnt'?
// 12:40
// if so, why would that make sense?
// then for dp[2] could we have done dp[1] + dp[1]? Or should we have checked for dp[2] because we have {2}?

// 12:41
// check up with Gemini
// 12:47
// let's turn what I've understood into my own words
// int[] coins = { 1, 2, 5 }
// dp[1]: the fewest coins to make up the amount 1

// how should I deal with the case of `dp[2]`?
// because dp[2-1] works, it just doesn't return the "minimum" number of coins to make up the amount 2.
// but to fix dp[2] = 1, we first need to evaluate the case `dp[2-1]` and conclude that it returns 2.

// (Gemini)
// Focus on this line: `dp[i] = Math.min(dp[i], dp[i - coin] + 1);`

// (My Followup Question)
// dp[i] = Math.min(dp[i], dp[i - coin] + 1);
// if we're doing this then we need to compare these four:
// (1) dp[2]
// (2) dp[2-1] + 1 = dp[1] + 1 = 2
// (3) dp[2-2] + 1 = dp[0] + 1 = 1
// (4) dp[2-5] + 1 = dp[-3] + 1 = infinity
// how the heck am I supposed to compare dp[2] and the other three options when dp[2] is not defined?

// (Gemini)
// This is the exact reason why we initialize the array before we start the loops.

// (My Followup Question)
// ah, ok, so we only set `dp[0] = 0`, and then all the other `dp[i]`s are initially set as 'inifinity'?
// 13:12

// 13:20
// I've handwritten all the logic

// Given int[] coins = { 1, 2, 5 }, amount = 11 ;
// dp[0] "amount 0을 만드는 최소 동전 개수"
// ### dp[0] = 0;


// dp[1] "amount 1을 만드는 최소 동전 개수"
    // (case1) dp[1-1] = dp[0]+ 1(1짜리 1개 더함) = 0 + 1 = 1;
    // (case2) dp[1-2] = dp[-1] + 1(2짜리 1개 더함) = impossible;
    // (case3) dp[1-5] = dp[-3] + 1(5짜리 1개 더함) = impossible;
    // dp[1] = min( case1, case2, case3 ) = min( 1, impossible, impossible ) = 1;
// ### dp[1] = 1;

// (13:27)
// 갑자기 dp[1] 논리가 이해가 안 감: amount 1을 만드는 경우의 수가, amount 0을 만드는 경우의 수 + 현재 선택한 동전의 개수(1개)라고?
// ... 했는데 내가 어디서 잘못 이해했는지 파악해버림... '경우의 수'가 아니라... '해당 값을 만드는 최소 동전 개수'잖아... 오와오...
// (13:28)

// dp[2] "amount 2을 만드는 최소 동전 개수"
    // (case1) dp[2-1] = dp[1](amount 1을 만드는 최소 동전 개수에 = 1개) + 1(1짜리 1개 더함) = 1 + 1 = 2;
    // (case2) dp[2-2] = dp[0](amount 0을 만드는 최소 동전 개수에 = 0개) + 1(2짜리 1개 더함) = 0 + 1 = 1;
    // (case3) dp[2-5] = dp[-3] (amount -3을 만드는 최소 동전 개수에 = 값이 없음 ) + 1(5짜리 1개 더함) = impossible;
    // dp[2] = min( case1, case2, case3 ) = min( 2, 1, impossible ) = 1;
// ###dp[2] = 1;

// dp[3] "마지막에 coins[i]짜리 동전 1개를 사용해서 amount 2을 만드는 최소 동전 개수"
// (case1) 마지막에 1짜리 동전 1개를 사용해서 amount 3 만들기: dp[3-1] = dp[2](amount 2을 만드는 최소 동전 개수에 = 1개) + 1(1짜리 1개 더함) = 1 + 1 = 2;
// (case2) 마지막에 2짜리 동전 1개를 사용해서 amount 3 만들기: dp[3-2] = dp[1](amount 1을 만드는 최소 동전 개수에 = 1개) + 1(2짜리 1개 더함) = 1 + 1 = 2;
// (case3) 마지막에 5짜리 동전 1개를 사용해서 amount 3 만들기: dp[3-5] = dp[-2] (amount -2을 만드는 최소 동전 개수에 = 값이 없음 ) + 1(5짜리 1개 더함) = impossible;
// dp[3] = min( case1, case2, case3 ) = min( 2, 2, impossible ) = 2;
// ###dp[3] = 2;

// dp[4] "마지막에 coins[i]짜리 동전 1개를 사용해서 최소 개수의 동전으로 amount 4을 만드는 최소 동전 개수"
// (case1) 마지막에 1짜리 동전 1개를 사용해서 최소 개수의 동전으로 amount 4 만들기: dp[4-1] = dp[3](amount 3을 만드는 최소 동전 개수에 = 2개) + 1(마지막으로 1짜리 1개 더함) = 2 + 1 = 3;
// (case2) 마지막에 2짜리 동전 1개를 사용해서 최소 개수의 동전으로 amount 4 만들기: dp[4-2] = dp[2](amount 2을 만드는 최소 동전 개수에 = 2개) + 1(마지막으로 2짜리 1개 더함) = 1 + 1 = 2;
// (case3) 마지막에 5짜리 동전 1개를 사용해서 최소 개수의 동전으로 amount 4 만들기: dp[4-5] = dp[-1] (amount -1을 만드는 최소 동전 개수에 = 값이 없음 ) + 1(마지막으로 5짜리 1개 더함) = impossible;
// dp[4] = min( case1, case2, case3 ) = min( 3, 2, impossible ) = 2;
// ###dp[4] = 2;

// dp[5] "마지막에 coins[i]짜리 동전 1개를 사용해서 최소 개수의 동전으로 amount 5를 만드는 최소 동전 개수"
// (case1) 마지막에 1짜리 동전 1개를 사용해서 최소 개수의 동전으로 amount 5 만들기: dp[5-1] = dp[4](amount 4을 만드는 최소 동전 개수에 = 2개) + 1(마지막으로 1짜리 1개 더함) = 2 + 1 = 3;
// (case2) 마지막에 2짜리 동전 1개를 사용해서 최소 개수의 동전으로 amount 5 만들기: dp[5-2] = dp[3](amount 3을 만드는 최소 동전 개수에 = 2개) + 1(마지막으로 2짜리 1개 더함) = 2 + 1 = 3;
// (case3) 마지막에 5짜리 동전 1개를 사용해서 최소 개수의 동전으로 amount 5 만들기: dp[5-5] = dp[0] (amount 0을 만드는 최소 동전 개수에 = 0개 ) + 1(마지막으로 5짜리 1개 더함) = 0 + 1 = 1;
// dp[5] = min( case1, case2, case3 ) = min( 3, 3, 1 ) = 1;
// ###dp[5] = 1;

// dp[6] "마지막에 coins[i]짜리 동전 1개를 사용해서 최소 개수의 동전으로 amount 6를 만드는 최소 동전 개수"
// (case1) 마지막에 1짜리 동전 1개를 사용해서 최소 개수의 동전으로 amount 6 만들기: dp[6-1] = dp[5](amount 5을 만드는 최소 동전 개수에 = 1개) + 1(마지막으로 1짜리 1개 더함) = 1 + 1 = 2;
// (case2) 마지막에 2짜리 동전 1개를 사용해서 최소 개수의 동전으로 amount 6 만들기: dp[6-2] = dp[4](amount 4을 만드는 최소 동전 개수에 = 2개) + 1(마지막으로 2짜리 1개 더함) = 2 + 1 = 3;
// (case3) 마지막에 5짜리 동전 1개를 사용해서 최소 개수의 동전으로 amount 6 만들기: dp[6-5] = dp[1] (amount 1을 만드는 최소 동전 개수에 = 1개 ) + 1(마지막으로 5짜리 1개 더함) = 1 + 1 = 2;
// dp[6] = min( case1, case2, case3 ) = min( 2, 3, 2 ) = 2;
// ###dp[6] = 2;
// 13:47