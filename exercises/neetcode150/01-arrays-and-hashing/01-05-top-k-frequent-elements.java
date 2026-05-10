// 21:05
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> numberToCount = new HashMap<>();
        for(int number : nums){
            numberToCount.put(number, numberToCount.getOrDefault(number, 0)+1);
        }

        List<Integer>[] buckets = new List[nums.length+1];
        for(Map.Entry<Integer, Integer> entry: numberToCount.entrySet()){
            int frequency = entry.getValue();
            int number = entry.getKey();
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(number);
        }

        int[] output = new int[k];
        int startIndex = 0;
        for(int i = buckets.length-1; i>=0; i--){
            if(buckets[i]!=null){
                for(int number: buckets[i]){
                    output[startIndex] = number;
                    startIndex++;

                    if(startIndex==k) return output;
                }
            }
        }

        return output;

    }
}