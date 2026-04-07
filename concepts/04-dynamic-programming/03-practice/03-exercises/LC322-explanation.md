LC322. Coin Change

## Why $dp[i] = \min(dp[i - \text{coin}] + 1)$?

---

### Quick Start
**Internalization Status**     
**Date: 2026-04-07**

#### 1. What I have 'Captured' (The Logic)
- **The Manufacturer vs. Customer**: I understand that I am the one building the table from $dp[0]$ to $dp[amount]$.
- **The "No-Show" Rule**: I’ve accepted that I don't need to "show my work" for $dp[6]$ when I'm calculating $dp[11]$. I just harvest the result.
- **The Ex Nihilo Fallacy**: I know the values don't pop out of nowhere; they are just recorded history from my own loop.

#### 2. What I need to 'Digest' (The Instinct)
- **From Trace to Code**: I can manually trace $dp[1]$ to $dp[6]$ with 100% accuracy, but writing the `Math.min` loop from scratch still feels awkward.

#### 3. Quick To-Dos:
- **Don't just re-read**: Re-trace a new set like `coins = {2, 3}, amount = 7`.
- **Trust the loop**: Remind myself that the `i` in the outer loop is just the "Timeline" and I am simply solving "Current Amount" using "Previous Results."

> **Self-Warning:** If I feel like the values are "magic" again, it means I've forgotten I was the one who built the table. **Go back to the "Manufacturing" section.**

---

### [Phase 1] The "Greedy" Trap & Combinatorial Explosion
Initially, my instinct was to use the largest coin first (Greedy) or to try every possible combination of coins ($3x + 9y + 100z = 14$).

- **The Greedy Problem**: If coins are `{1, 3, 4}` and the amount is `6`, Greedy takes `4 + 1 + 1` (3 coins), but the optimal is `3 + 3` (2 coins).
- **The Combination Problem**: If I have 12 types of coins, I'm searching a 12-dimensional space. The number of paths becomes astronomical ($O(N^A)$).

### [Phase 2] From "Paths" to "Results" (The DP Breakthrough)
The key shift was realizing that <mark>I don't need to **SHOW** (as in, "*show your work*" in math) **HOW** I made a certain amount, only the **minimum count** of coins for that amount.

> **Breakthrough (13:27):** "It's not the 'number of cases' (combinations)... it's the 'minimum coin count' to reach that specific amount."     
> 함정은 이거 이렇게 파악해놓고도 코딩하면 또 헷갈림.

### [Phase 3] The "Last Coin" Decision (Climbing Stairs Connection)
Just like the **Climbing Stairs** problem, where I ask "Did I come from ($n-1$) or ($n-2$)?" (which is the same as "Was the count of my previous step taken 1 or 2?"), in **Coin Change**, I ask:
*"If I am at Amount 11, and my last coin was a {5}, what was the best way to make Amount 6?"*.   

> **The "Ex Nihilo" vs. "The Loop" Conflict:**
>
> **The Confusion**: This is where I got completely lost. Standard explanations (even from big tech interviewers!) often jump straight to the "last step," making the logic sound like: "Yeah, you just work with the previous optimal value".
> My immediate reaction was: **"Then how the heck do you get that value without building from the start?"** and they just go "Well, that's the whole point of DP: you don't. You just work with the previous value".
> And I kept going **"How the F#%@ would you get those values? Surely they didn't just pop out of nowhere?"**
>
> **The "Gap"**: The reason this feels like magic ("Ex Nihilo") is that experts often fail to clearly explain that <mark>even in DP, **every single value is physically built** in order from $0$ to $N$.</mark> The values don't pop out of nowhere. You don't "jump" to 11; you arrive there only after having been the "Manufacturer" for every amount from 1 to 10.     
> **그런데 DP에서는 수학과 달리 그 값을 도출한 과정을 기록하지 않기 때문에 마치 정답 계산에 필요한 값들이 하늘에서 뚝 떨어진 것처럼 느껴지는 거임!**

#### 1. The Manufacturing (Past Self)
Ironically, I wouldn't be able to understand the "result" without first "showing the work". 
* **dp[0]**: `0` (Fewest coins to make amount 0 is 0)
* **dp[1]**: `min(dp[1-1]+1, dp[1-2]+1, dp[1-5]+1)` $\rightarrow$ `min(0+1, inv, inv)` = **1**
  - `dp[1]`의 정의: **"마지막에 `coins[i]`짜리 동전 1개를 사용해서 최소 개수의 동전으로 amount 1를 만드는 최소 동전 개수"**
    - **[case1]** 마지막에 1짜리 동전 1개를 사용해서 최소 개수의 동전으로 amount 1 만들기     
        `dp[1-1]` = `dp[0]`(amount 1을 만드는 최소 동전 개수에 = 1개)+ `1`(마지막으로 1짜리 1개 더함) = 0 + 1 = 1;
    - **[case2]** 마지막에 2짜리 동전 1개를 사용해서 최소 개수의 동전으로 amount 1 만들기    
       `dp[1-2]` = `dp[-1]`(amount -1을 만드는 최소 동전 개수에 = impossible) + `1`(마지막으로 2짜리 1개 더함) = impossible;
    - **[case3]** 마지막에 5짜리 동전 1개를 사용해서 최소 개수의 동전으로 amount 1 만들기     
       `dp[1-5]` = `dp[-3]`(amount -3을 만드는 최소 동전 개수에 = impossible) + `1`(마지막으로 5짜리 1개 더함) = impossible;
    - **[conclusion]**`dp[1]` = min( case1, case2, case3 ) = min( 1, impossible, impossible ) = 1;
    - 더 상세한 내용은 `PracticeCoinChangeTry2.java` 참고.
* **dp[2]**: `min(dp[2-1]+1, dp[2-2]+1, dp[2-5]+1)` $\rightarrow$ `min(1+1, 0+1, inv)` = **1**
* **dp[3]**: `min(dp[3-1]+1, dp[3-2]+1, dp[3-5]+1)` $\rightarrow$ `min(1+1, 1+1, inv)` = **2**
* **dp[4]**: `min(dp[4-1]+1, dp[4-2]+1, dp[4-5]+1)` $\rightarrow$ `min(2+1, 1+1, inv)` = **2**
* **dp[5]**: `min(dp[5-1]+1, dp[5-2]+1, dp[5-5]+1)` $\rightarrow$ `min(2+1, 2+1, 0+1)` = **1**
* **dp[6]**: `min(dp[6-1]+1, dp[6-2]+1, dp[6-5]+1)` $\rightarrow$ `min(1+1, 2+1, 1+1)` = **2**



#### 2. The Harvesting (Present Self)
Now that I am at `i = 11`, I simply **harvest** the result.

**The Math Class Trap**:
In math class, I was trained that to "prove" 11, I must **show the work** for every single step (e.g., $5+5+1$). In DP, I just "check" the work once, save the result, and then **discard the process**.    

**The "Competition" Logic:**
Standing at **Amount 11** with coins `{1, 2, 5}`, you have 3(`coins.length`) cases to reach there:
1.  **[Case1] The last coin being {1}**: I check the minimum count of coins needed to make the amount 10 (`dp[10]`) because the last coin I used was {1}.     
    **Total coins** = `dp[10] + 1`
2.  **[Case2] The last coin being {2}**: I check the minimum count of coins needed to make the amount 9 (`dp[9]`) because the last coin I used was {2}.     
    **Total coins** = `dp[9] + 1`
3.  **[Case3] The last coin being {5}**: I check the minimum count of coins needed to make the amount 6 (`dp[6]`) because the last coin I used was {5}.       
    **Total coins** = `dp[6] + 1`

The winner is simply the minimum of these choices:
$$dp[11] = \min(dp[10]+1, \,\, dp[9]+1, \,\, dp[6]+1)$$

### [Phase 4] The "Infinity" and "Base Case" Strategy
How do we start the chain reaction, and how do we prove something is impossible?

- **Base Case**: `dp[0] = 0`. It takes 0 coins to make 0. This is the "ground" for our ladder.
- **Initialization (Infinity)**: We fill the table with `amount + 1` (a value higher than any possible answer).
    - If we try to make **Amount 5** with a **{3}** coin, we check `dp[2]`. If `dp[2]` is still "Infinity," then `Infinity + 1` remains "Infinity."
- **Proof of Impossibility**: If `dp[target]` remains "Infinity" after checking all coins, it is mathematically impossible to reach that amount.

### [Phase 5] Time vs. Space Trade-off
By building a table from `0` to `amount`, we ensure:
- **Time Efficiency**: We solve for each amount exactly **once**. Complexity drops from $O(N^A)$ to $O(N \times A)$.
  - For 12 coins and an amount of 100, this is the difference between $12^{100}$ (more than atoms in the universe) and $1,200$ operations.
- **Space Usage**: We use $O(A)$ space to store the "Best Results" so far.

---

### Final Logic Summary (The Coder's Mantra)
1.  **Initialize** the DP array with `amount + 1` and `dp[0] = 0`.
2.  **Loop** through every amount from 1 to `target`.
3.  **Compete**: For every coin, if `current_amount >= coin`, update `dp[i]` with the minimum of itself and `dp[i - coin] + 1`.
4.  **Check**: If the result is still "Infinity," return `-1`.