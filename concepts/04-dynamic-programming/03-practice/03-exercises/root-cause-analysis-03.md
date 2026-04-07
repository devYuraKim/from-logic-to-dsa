# Root Cause Analysis 03

The Cognitive Shift from Combinatorics to Dynamic Programming

`PracticeCoinChangeTry1.java`


# RCA: 사고방식의 전환 (수학적 조합론에서 공학적 DP로)

수학적 사고(조합론)와 공학적 사고(DP)는 문제를 바라보는 '시점' 자체가 완전히 다르기 때문이에요. 냉정하게 그 차이를 해부해 드릴게요. 왜 유라님이 그렇게 힘들었는지, 그리고 그 전환의 핵심이 무엇인지 말이죠.

## 1. 수학적 사고: [완성된 그림]을 펼쳐놓고 분석하기
유라님이 익숙하신 수학적 관점은 **'조합(Combination)'**입니다.
* **사고의 흐름**: "11을 만들 수 있는 모든 숫자 세트($1+5+5, 2+2+2+5...$)를 일단 다 책상 위에 늘어놓자. 그리고 그중에서 숫자의 개수가 가장 적은 놈을 골라내자."
* **특징**: 전체를 한꺼번에 조망해야 합니다. 숫자가 커질수록 우리가 머릿속에 그려야 할 조합의 가짓수가 **폭발(Exponential Explosion)**하게 되죠. 그래서 인간의 뇌로는 한계가 옵니다.

## 2. 공학적 사고(DP): [벽돌 한 장]의 인과관계에 집중하기
반면 DP는 전체 조합을 궁금해하지 않습니다. 오직 **'직전 단계와의 연결'**만 봅니다.
* **사고의 흐름**: "내가 지금 11원 지점에 서 있어. 내가 여기 오기 바로 직전 한 걸음은 1원 전(10원), 2원 전(9원), 아니면 5원 전(6원)이었겠지? 그럼 그 세 지점 중에서 가장 효율적으로 도착해 있던 놈한테 내 동전 하나만 얹으면 내가 제일 빨라!"
* **특징**: 전체 조합을 나열하지 않고, **'현재 상태 = 이전 상태 + 선택'**이라는 점화식 하나로 모든 문제를 단순화합니다.


## 3. 왜 전환이 어려웠을까? : [전체] vs [국소]
유라님은 **"전체 조합을 모르는 상태에서 어떻게 최적을 확신해?"**라는 의구심 때문에 힘드셨을 거예요.
* **수학**: "모든 조합을 확인해야 확신할 수 있다." (전수 조사)
* **DP**: "0부터 내 발밑까지 이미 최적으로 쌓아왔다는 **'귀납적 믿음'**이 있다면, 나는 지금 내 발밑의 선택만 고민하면 된다." (국부 최적화의 누적)


## 4. 핵심의 전환: "무엇을 버릴 것인가"
수학적 조합론은 **'과정(어떤 숫자들이 쓰였는가)'**을 모두 들고 있으려 합니다. 하지만 DP는 과정은 버리고 **'결과(최소 개수)'**만 남깁니다.
* **수학**: "$1+5+5$니까 3개야."
* **DP**: "어떻게 왔는지는 관심 없고, 11원까지 오는 데 최소는 3이야."

이 **'정보의 압축'**을 받아들이는 과정이 유라님에게는 "무에서 유를 창조하는 것 같은" 불안함으로 다가왔던 것이죠. 하지만 어제 100분간의 사투 끝에 유라님은 그 '압축된 숫자'가 사실은 수많은 조합의 정수라는 것을 이해하신 겁니다.

---

### Gemini의 드라이한 응원
유라님, 사고방식을 바꾼다는 건 뇌의 회로를 새로 까는 작업과 같습니다. "11을 쪼개서 조합을 찾자"는 Top-down(분석적) 사고에서, "0부터 벽돌을 쌓아 11을 만들자"는 Bottom-up(건설적) 사고로 넘어오신 거예요. 이제 유라님은 문제를 만났을 때 두 가지 눈을 다 갖게 되었습니다.

* **수학의 눈**: 문제의 전체적인 구조와 조합의 가능성을 파악함.
* **공학의 눈**: 그것을 효율적인 '단계'로 쪼개서 컴퓨터가 풀 수 있게 만듦.

이 전환이 어려웠던 만큼, 이제 유라님이 짜는 코드는 훨씬 더 견고한 논리적 토대 위에 서 있게 될 겁니다. 이제 Coin Change 문제를 풀 때, 그 '조합'들이 dp 배열 안에 숫자로 예쁘게 압축되어 쌓이는 모습이 상상이 가시나요?

---

---

## My Thought Process

Refer to `PracticeCoinChangeTry1.java`

### 19:05
It’s impressive to see your thought process laid out like this. You’ve successfully navigated the most difficult part of learning Dynamic Programming: **the mental shift from "searching for a combination" to "building a sequence of optimal states."**

Watching your notes evolve from $17:10$ to $18:57$ shows a textbook transition that even experienced developers sometimes struggle with. Here is an objective review of that journey.

---

## 1. Evaluation of Your Logic Evolution

| Stage | Your Thought Pattern | Status | Objective Critique |
| :--- | :--- | :--- | :--- |
| **17:10** | **Greedy Instinct** | ❌ | You assumed picking the largest coin first leads to the answer. This fails for non-standard coin sets. |
| **17:57** | **The $x, y, z$ Equation** | ⚠️ | You correctly identified the mathematical problem, but tried to solve it as a multi-dimensional search (Brute Force). |
| **18:10** | **The Redundancy Realization** | ✅ | You noticed you were "making the same mistakes." This is the moment you realized Brute Force repeats work. |
| **18:45** | **The "Stairs" Pattern** | 🎯 | **The Breakthrough.** You linked the problem to "Climbing Stairs," recognizing that Amount $N$ depends on Amount $N - \text{step}$. |
| **18:57** | **State-Based Progress** | 🏆 | You finalized the logic: Standing at destination $i$, check every possible "previous step" $(i - \text{coin})$. |

---

## 2. Why your "Looking Back" is so powerful
Your conclusion at **19:01** (*"If the amount is 6, we check with every element as its previous step"*) is exactly how $O(N \times A)$ complexity is achieved.

By checking every coin only **once** per amount, you've turned a problem that would normally take $12^{10,000}$ operations into one that takes only $120,000$. You aren't searching through a 12-dimensional space; you are simply filling a 1-dimensional array.

---

## 3. Final Implementation Checklist
As you move from this thought process to final code, keep these three technical "guardrails" in mind:

1.  **The Base Case:** Always ensure `dp[0] = 0`. Without this, the "look back" chain has no ground to stand on.
2.  **The Comparison:** Use `Math.min(dp[i], dp[i - coin] + 1)`. This is the "competition" where the fewest coins win.
3.  **The Impossible Check:** Before adding `+1`, check if `dp[i - coin]` is still your "Infinity" value. You can't build a path on a foundation that doesn't exist.

---

### Final Opinion
Your process was not a "loop of mistakes"; it was a **refinement**. You had to discard the Greedy approach and the Brute Force approach to truly understand *why* DP exists.

The fact that you caught the "Climbing Stairs" connection on your own suggests you’ve internalized the **Optimal Substructure** property—the idea that an optimal solution to a big problem (Amount 11) is made of optimal solutions to smaller problems (Amount 10, 9, or 6).

---

---

## 1. The Core Conflict: Mathematical Analysis vs. Engineering Construction
The difficulty I experienced stems from the fundamental difference in how these two fields perceive a "solution."

* **The Mathematical Perspective (Combinatorial):** I viewed the problem as a **Completed Picture**.
    * **Logic:** "To find the minimum, I must first see all valid sets (1+5+5, 2+2+2+5, etc.) laid out on the table, then pick the shortest one."
    * **The Issue:** This requires the brain to hold a "global view." As the target amount or the number of coins increases, the number of combinations explodes ($O(N^A)$), leading to cognitive overload.
* **The Engineering Perspective (DP):** I viewed the problem as a **Causal Link**.
    * **Logic:** "I don't need to see the 'sets.' I only need to know my **immediate previous step**. If I am at 11, I must have come from 10, 9, or 6. I simply trust that the people standing at 10, 9, and 6 have already found their own best paths."
    * **The Result:** You collapse a high-dimensional search space into a simple, 1D array of "best results."



---

## 2. The Solution: Shifting from "Global Search" to "Local Optimization"
The breakthrough happened when I stopped trying to "find the combination" and started "building the result."

* **Mathematical Proof (Top-Down):** Starts with the target (11) and breaks it down. It feels "smarter" because it’s analytical, but it’s harder for a computer to manage without huge memory overhead (Stack).
* **DP Construction (Bottom-Up):** Starts with the absolute truth ($dp[0] = 0$) and conquers territory one cent at a time. It ensures that by the time you reach 11, every single step behind you is already a "proven fact."



---

## 3. The "Aha!" Moment: Information Compression
The hardest part of this shift was accepting **Information Loss**.

* **Combinatorics** wants to keep the **"Process"** (Which coins were used? 1, 5, 5).
* **DP** throws away the process and only keeps the **"Result"** (How many coins? 3).

I felt like I was "creating something from nothing" because I couldn't see the coins anymore—I only saw the numbers in the `dp` table. But as I realized, those numbers are the **distilled essence of millions of combinations**, compressed into a single integer.

---

## 4. Summary: The "Relay Race" Intuition
In my RCA, the solution is defined as follows:

> "Instead of being one person trying to run every possible path in a maze (Search), I placed a person at every 'amount' from 0 to 11. Each person only had to look back one 'coin-jump' and take the best result from their predecessors. This turned an impossible $12^{100}$ search into a simple $12 \times 100$ calculation."



---

## 5. Final Diagnostic
I moved from a **Searcher** mindset to a **Builder** mindset. Now, when I look at `dp[i - coin]`, it’s no longer a "magic number falling from the sky"—it’s a baton being handed to me by a previous version of myself who already did the hard work.