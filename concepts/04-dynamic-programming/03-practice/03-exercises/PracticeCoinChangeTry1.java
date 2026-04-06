// 17:10

public class PracticeCoinChangeTry1 {

    public static void main (String[] args) {

        System.out.println(getCoinChange([1,2,5], 11));
        System.out.println(getCoinChange([2], 3));
        System.out.println(getCoinChange(1), 0));

    }

    public static int getCoinChange(int[] coins, int amount){

    //condition 1. THE FEWEST number of coins
    //condition 2. CAN or CANNOT be made
        //2-1. -1 for CANNOT
        //2-2. 0 for not using any coins
        //2.3. integer for CAN
    //condition 3. INFINITE each coin

        return fewestNumberOfCoins;
    }

}


// Pseudocode

// 1. The question is 'To Select or Not To Select'
// 2. Let's start with Example 1: [1,2,5] 11
    // (1) if we use 1, we have 10 left, we could go with all 1, which will end up with "11 coins" (fewestNumberOfCoins=11)
    // (2) if we do (1, 1, 1, 1, 1, 1, 1, 1, 1, 2) we will end up with "10 coins" (fewestNumberOfCoins=10)
    // (3) if we do (1, 1, 1, 1, 1, 1, 1, 2, 2) we end up with "9 coins" (fewestNumberOfCoins=9)

    // come on, I need to find a pattern about now
    // (3) if we do (1, 1, 1, 1, 1, 2, 2, 2) we end up with "8 coins" (fewestNumberOfCoins=8)
    // (4) if we do (1, 1, 1, 2, 2, 2, 2) we end up with "7 coins" (fewestNumberOfCoins=7)
    // (5) if we do (1, 2, 2, 2, 2, 2) we end up with "6 coins" (fewestNumberOfCoins=6)

    // wait, I'm curious if I should check if I can make 'the bigget element' using the other elements?
    // and my thought process went to 'how do I track all those 'number of coins'? if I find a smaller value, do I just discard the previous value and update it to a new one?
    // (6) if we do (5, 1, 1, 1, 1, 1, 1) we end up with "7 coins" (fewestNumberOfCoins=6)
    // (7) if we do (5, 1, 1, 1, 1, 2) we end up with "6 coins" (fewestNumberOfCoins=6)
    // (8) if we do (5, 1, 1, 2, 2) we end up with "5 coins" (fewestNumberOfCoins=5)
    // (9) if we do (5, 2, 2, 2) we end up with "4 coins" (fewestNumberOfCoins=4)
    // (10) if we do (5, 5, 1) we end up with "3 coins" (fewestNumberOfCoins=3)

    // wait, does 'Greedy' work here? Is there a counter example for 'greedy logic'?
    // (i) 11 - 5 = 6 > 0 (fewestNumberOfCoins=1)
    // (ii) 6 - 5 = 1 > 0 (fewestNumberOfCoins=2)
    // (iii) 1 - 5 = -4 < 0 (fewestNumberOfCoins=2)
    // (iv) 1 - 1 = 0 = 0 (fewestNumberOfCoins=3)
    // (v) therefore, it is possible to get an answer of 3

    // let's try doing an example of my own [3, 4, 7] and amount 13
    // (1) 13 - 7 = 5 > 0 (fewestNumberOfCoins=1)
    // (2) 5 - 7 = -2 < 0 (fewestNumberOfCoins=1)
    // (3) 5 - 4 = 1 > 0 (fewestNumberOfCoins=2)
    // (4) 1 - 4 = -3 < 0 (fewestNumberOfCoins=2)
    // (5) 1 - 3 = -2 < 0 (fewestNumberOfCoins=2)
    // (6) therefore it is impossible to get an answer

    // 17:33
    // let's assume the array 'coins' is sorted, ascending
    // we will go in a loop from the last element of the array
    // (1) check if (amount) - (coins[coins.length-i]) >= 0 (where i starts from 0 to 'coins.length/)
    // (2) if it is >=0, we will "update" amount to "current amount" & fewestNumberOfCoins to "+1" and "repeat" the same process with the "same element(the current one)" coins[coins.length-i]
    // (*) but how am I supposed to do this while in a loop?
    // (3) if it is < 0, we will "move on" to the next element
    // (4) we will keep going on until we reach the first element in the 'coins' array
    // (5) if "current amount" is 0, we will return the current 'fewestNumberOfCoins' and if not return -1
    // 17:39


    // 17:41
    // Proofread with Gemini.
    // I need to stop relying on the "Greedy Algorithm."
    // I have no idea why I keep defaulting to it.

    // (took a short break) 17:50
    // OK, then I need to try out 'all of the possible combinations' and keep track of the 'number of coins used' and then return the least value
    // But then how do I keep track of 'all the possible combinations' and at the same time check if that can make up the 'amount'?

    // 17:54
    // Let's start small. Let's just start with the assumption that 'the amount can be made up'
    // Then we will start with my first approach. Starting with the smallest, then trying adding in different coins. Finally we will end up with the 'least number of coins used'

    // 17:57
    // What if there may not be a possible answer? How do we check if there is an answer or not?
    // Say we have int[] coins = { 3, 9, 100 } and  int amount = 14. How can we tell if we can make up 14 using the given elemnts?
    // The equation would be 14 = 3x + 9y + 100z, where x, y, and z are all 'integer' (but mind that the length of the array can grow upto 12)
    // We know that mathematically it doesn't work, but how do we prove it 'code-wise'?
    // I mean we could go up from (x, y, z) (0, 0, 0) to (14/3, 14/9, 14/100)

    // 18:01
    // Wait, I think I will develop my last approach. I mean, the bottom is (0,0,0) and the ceiling would be (4, 1, 0), no?

    // (Proofread with Gemini)
    // 18:08
    // You are currently describing a Brute Force or Exhaustive Search approach.
    // While it is mathematically sound to think of this as a linear Diophantine equation ($3x + 9y + 100z = 14$), there are a few things to consider regarding your "track."
    // Mathematically: Yes. You are essentially saying, "Let's try every possible combination of $x, y, z$ until we find a match or run out of options."
    // Code-wise: Not exactly. If the array length grows to 12, you would need 12 nested loops to check every combination. This is what we call an $O(N^k)$ complexity problem, which becomes incredibly slow as the number of coin types ($N$) or the amount increases.

    // 18:10
    // I'm stuck in a loop where I'm making the same mistakes as the last time! (First Greedy Algorithm, then Integer Partition)
    // But I thought we need to go over all the cases anyways just like in Fibonacci Sequecne? Even for DP? The only difference is if we 'record' that or not?

    // (Guidance from Gemini)
    // 18:17
    // When you try to find $14 = 3x + 9y + 100z$, you are essentially trying to build the house by testing every possible pile of bricks.
    // The Problem: If you have 12 types of coins, you are searching a 12-dimensional space.
    // The DP Solution: You don't care about the specific $x, y, z$ values until the very end. You only care about the amount.

    // (My Follow-up Question)
    // But to get the 'specific values' you need to try out all the combinations, no?

    // (Gemini's answer)
    // This is exactly where the "magic" of Dynamic Programming (DP) happens. To answer your question directly: Yes, you technically "try" the combinations, but you do it in a way that prevents the "12-dimensional" explosion.



    // (My Follow-up Question)
    // But even in DP, you still have to go over all the combinations, no?

    // (Gemini's answer)
    // You are touching on the most subtle and important distinction in all of computer science: the difference between **Combinatorial Search** and **State-Based Progress**.

    // ### 1. The Core Disagreement: "Checking" vs. "Branching"
    // You are absolutely right that you have to "check" every coin. If you have coins `{1, 2, 5}`, you still have to look at all three.
    // The difference is **redundancy**.

    // **Your "Search" (Combination) Approach**: You are building "**Paths**."
    // - Path 1: `1+1+1+1+1`
    // - Path 2: `1+2+2`
    // - Path 3: `5`
    // - If you have 12 coins and the amount is 10,000, the number of "Paths" is astronomical. You end up checking the same "sub-path" (like how to make 5) millions of times.

    // **The DP Approach**: You are building "**Results**."
    // - You ask: "What is the best way to make 5?"
    // - You check `1 + dp[4]`, `2 + dp[3]`, and `5 + dp[0]`.
    // **Crucially**: You only do this **once** for the number 5.
    // Once you decide that `dp[5] = 1`, you **never check a combination that sums to 5 ever again**. You just use the number `1`.

    // ### 2. How DP "Checks" Without "Searching Combinations"
    // Think of it like a relay race instead of a maze.
    // In a **Search**, you are one person trying to run every possible path in a maze to find the exit. You might run down the same hallway 100 times because it's part of 100 different paths.
    // In **DP**, you put a person at every meter mark of the race:
        // 1. The person at 1m finds the best way to get there.
        // 2. The person at 2m looks at the person at 1m and says, "Can I get here better from you, or from 0?"
        // 3. By the time you get to 14m, the person at 14m doesn't care about the "combinations" that happened at 2m or 5m. They only care about the final answer those people found.

    // ### 3. "You just don't save it" — Actually, we save the Result, not the Path
    // When you say "you just don't save it," you're highlighting the efficiency.
    // - **Search** tries to remember/explore the "**How**" (the combination of $x, y, z$).
    // - **DP** only remembers the "**How Much**" (the minimum count).
    // By only saving the "How Much," you collapse the 12-dimensional search space into a simple 1-dimensional array. You "check" each coin for each amount, but you **never re-check the same amount twice**.

    // ### 4. Mathematical Comparison
    // If $A$ is the amount and $N$ is the number of coins:
    // - **Search/Combinations**: $O(N^A)$ — This is where the "12-dimensional" explosion happens.
    // - **DP**: $O(N \times A)$ — This is a simple multiplication.
    // If $A=100$ and $N=12$:
    // - **Search**: $12^{100}$ (More than atoms in the universe).
    // - **DP**: $12 \times 100 = 1,200$ (A fraction of a millisecond).



    // (My Follow-up Question)
    // "but you **never re-check the same amount twice**." Isn't this the same with brute force? or is it not?

    // (Gemini's Answer)
    // This is the exact point where the "loop" in your logic is happening. The short answer is: No, Brute Force re-checks the same amount millions of times.
    // To understand why, we have to look at the Decision Tree.

    // ### 1. Brute Force (The "Tree" of Madness)
    // Imagine `coins = {1, 2}` and `amount = 4`.
    // In Brute Force, you explore every branch:
    // - Branch A: Take 1. Remaining is 3.
        // - From 3, take 1. Remaining is 2.
        // - From 3, take 2. Remaining is 1.
    // - Branch B: Take 2. Remaining is 2.
    // Look closely: You just encountered the "Remaining amount = 2" twice.
    // - 1. Once via the path `(1, 1)`
    // - 2. Once via the path `(2)`
    // In Brute Force, you will calculate "How do I make 2?" every single time it appears at the end of a branch. If the amount is 10,000, the amount "2" will appear as a remainder trillions of times. You are re-solving the same problem over and over.

    // ### 2. 2. DP (The "Table" of Efficiency)
    // In DP, you work from the bottom up. You solve for 2 once and store it.
    // 1. Solve for 0: (Result: 0)
    // 2. Solve for 1: (Result: 1)
    // 3. Solve for 2: (Result: 1) — Saved in `dp[2]`
    // 4. Solve for 3: (Result: 2) — Saved in `dp[3]`
    // 5. Solve for 4: You check `1 + dp[3]` and `1 + dp[2]`.
    // When you "check" `dp[2]`, you aren't calculating how to make 2. You are just grabbing the number `1` from a shelf. You don't care if 2 was made by `(1+1)` or `(2)`; you just take the pre-calculated minimum.



    // 18:36
    // oh dang it, it just made sense
    // so the whole point is we check from amount 0 to the given amount
    // and we just check if amount = 0, 1, 2, 3, ..., give amount can be made
    // but the the starting point will be the 'minimum' number of coins of the previous step
    // am I making sense here?

    // (Smart Gemini answered my next question)
    // ### 3. How this handles "No Possible Answer"
    // This also solves your earlier question about how to "prove" something is impossible.
    // If you are at Amount 7 and your coins are `{3, 9}`, you check:
    // - dp[7 - 3] (Amount 4) $\rightarrow$ Was it possible? (No, it's still "Infinity")
    // - dp[7 - 9] $\rightarrow$ (Impossible, 9 is too big)
    // Since no previous step could reach 7, `dp[7]` remains "Infinity." The "proof" is simply the absence of a path from a previously solved sub-problem.



    // 18:40
    // wait, where the heck did 'infinity' come from? what? why are we going `dp[7-3]`? I thought we were supposed to build up from `dp[0]` to `dp[amount]`?

    // (Gemini's answer)
    // You are exactly right—we are building from dp[0] up to dp[amount].
    // The "infinity" and the "looking back" (dp[7-3]) are just two sides of the same coin. Let’s break down why they exist in the "building up" process.

    // ### 1. Why "Looking Back" is "Building Up"
    // When you are building a brick wall, to lay the 7th row, you must stand on the 4th or 6th row.
    // If you are currently calculating dp[7] (Amount 7) and you have a $3 coin, you are essentially asking:
    // "If I use this $3 coin to reach 7, what was the best way to get to the remaining 4?"
    // Looking back at dp[4] isn't "re-calculating" 4; it's just grabbing the answer you already finished when you were on step 4 of your 0 to amount loop.

    //
    // 18:45 (me cutting in)
    // wait, wait, wait. so this is just like the 'climbing stairs' problem. If I ended up on the 'final step' where was I previously? Right?

    // (Gemini) Bullseye. You’ve nailed the intuition. The "Climbing Stairs" problem and the "Coin Change" problem are essentially siblings in the DP family.
    //

    // (back to OG response)
    // ### 2. Where did "Infinity" come from?
    // "Infinity" is just a coder's way of saying "Mission Impossible." When you start, you don't know if any amount can be made. So, you mark every amount (except 0) as "Infinity" (or a very large number like `amount + 1`).
    // Example: `coins = {3}`, `amount = 5`
    // 1. `dp[0] = 0` (Base case: 0 coins to make 0)
    // 2. `dp[1]`: Can I use a 3? No (1 < 3). It stays Infinity.
    // 3. `dp[2]`: Can I use a 3? No (2 < 3). It stays Infinity.
    // 4. `dp[3]`: Can I use a 3? Yes!
        // - Look back at `dp[3 - 3]` (which is `dp[0]`).
        // - `dp[0]` is 0. So `dp[3] = 0 + 1 = 1`.
    // 5. `dp[4]`: Can I use a 3? Yes.
        // - Look back at `dp[4 - 3]` (which is `dp[1]`).
        // - `dp[1]` is Infinity.
        // - `Infinity + 1` is still Infinity.
    // 6. `dp[5]`: Can I use a 3? Yes.
        // - Look back at `dp[5 - 3]` (which is `dp[2]`).
        // - `dp[2]` is Infinity.
        // - Result stays Infinity.
    // At the end, dp[5] is still "Infinity," which tells you it's impossible.



    // 18:51
    // (My Follow-up Question) What if there are multiple elements than just one? How can you tell which one works?

    // (Gemini)
    // ### 1. The "Competition" Logic
    // If `coins = {1, 2, 5}` and you are at Amount 6:
        // - Option A (Use a 1 coin): Look at `dp[6 - 1]` (Amount 5). If `dp[5]` is 1, then this path takes $1 + 1 = 2$ coins.
        // - Option B (Use a 2 coin): Look at `dp[6 - 2]` (Amount 4). If `dp[4]` is 2, then this path takes $2 + 1 = 3$ coins.
        // Option C (Use a $5 coin): Look at `dp[6 - 5]` (Amount 1). If `dp[1]` is 1, then this path takes $1 + 1 = 2$ coins.
    // The Winner: `dp[6] = Math.min(Option A, Option B, Option C)`. In this case, it would be 2.

    // (me interrupting)
    // oh, so we check 'all the elements' but start from the 'end destination'?
    // so if the amount is 6, we check with every element as its previous step and see if that is a possible way?

    // (Gemini)
    // Exactly. You’ve hit the nail on the head.
    // Standing at your "current destination" (like Amount 6), you look back exactly one "coin-jump" for every coin in your set. You are essentially asking: "If I were to use this specific coin as the very last coin to reach 6, where would I have had to come from?"

    // got it!