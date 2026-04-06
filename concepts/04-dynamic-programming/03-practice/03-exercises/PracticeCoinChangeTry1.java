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

    // (break)