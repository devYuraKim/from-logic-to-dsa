### Original Code
```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int max = piles[0];

        for(int baCount : piles){
            if(max < baCount){
                max = baCount;
            }
        }


        for(int k = 1; k <= max; k++){

            int totalHours = 0;

            for(int baCount : piles){

                if(baCount % k != 0){
                    totalHours += baCount/k + 1;
                }else{
                    totalHours += baCount/k;
                }

            }

            if(totalHours <= h){
                return k;
            }
        }

        return -1;

    }
}

```

| 항목 | Original Code       | Polished Code         |
| :--- |:--------------------|:----------------------| 
| **Max 탐색** | `if(max < baCount)` | `Math.max(max, pile)` | 
| **시간 합산** | `int`               | `long`                | 
| **올림 계산** | `if-else` 조건문       | `(pile + k - 1) / k`  |
| **중도 중단** | 끝까지 계산함             | `h` 초과 시 즉시 `break`   | 
*** 중도 중단 *** 조건 넣으면 TLE 안 떠!!!!!

### Polished Code
```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;
        
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        for (int k = 1; k <= max; k++) {
            
            long totalHours = 0;

            for (int pile : piles) {

                totalHours += (pile + k - 1) / k;
                
                if (totalHours > h) break;
            }

            if (totalHours <= h) {
                return k;
            }
        }

        return max;
    }
}
```