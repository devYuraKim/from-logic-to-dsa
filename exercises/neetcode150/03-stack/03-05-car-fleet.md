### Stack 이용 풀이

```java
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Pair positions with speeds, then sort by position descending
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        Arrays.sort(indices, (a, b) -> position[b] - position[a]);

        Deque<Double> stack = new ArrayDeque<>();

        for (int i : indices) {
            double time = (double)(target - position[i]) / speed[i];
            // Only push if this car is slower than the fleet ahead
            // (i.e., it won't catch up → new fleet)
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            // else: this car catches up to the fleet ahead, merges → skip
        }

        return stack.size();
    }
}
```