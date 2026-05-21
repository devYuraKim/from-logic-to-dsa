// Fri May 22 2026
// 43'09'' + LLM Feedback
class TimeMap {

    class ValueTime{
        String value;
        int timestamp;
        public ValueTime(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<ValueTime>> keyValueTimeMap;

    public TimeMap() {
        keyValueTimeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        ValueTime newValueTime = new ValueTime(value, timestamp);
        if(!keyValueTimeMap.containsKey(key)){
            //keyValueTimeMap.put(key, newList.add(newValueTime));
            List<ValueTime> newList = new ArrayList<>();
            newList.add(newValueTime);
            keyValueTimeMap.put(key, newList);
        }else{
            keyValueTimeMap.get(key).add(newValueTime);
        }
    }

    public String get(String key, int timestamp) {
        if(keyValueTimeMap.containsKey(key)){
            List<ValueTime> valueTimeList = keyValueTimeMap.get(key);

            int left = 0;
            int right = valueTimeList.size()-1;

            String result = "";

            while(left<=right){
                int mid = (left+right)/2;
                if(valueTimeList.get(mid).timestamp < timestamp){
                    result = valueTimeList.get(mid).value;
                    left=mid+1;
                }else if(valueTimeList.get(mid).timestamp > timestamp){
                    right=mid-1;
                }else{
                    // if(left=mid=right){
                    //     return mid;
                    // }else if(valueTimeList.get(mid).timestamp == timestamp){
                    //     return mid;
                    // }
                    return valueTimeList.get(mid).value;
                }
            }

            // ["alice": {1,2,3,4,5,6,7,8,9}] timestamp=8
            // left=0, right=8, mid=4
            // [4]mid=5 < timestamp=8: 0부터 mid까지 다 버림
            // left=mid+1=5, right=8, mid=6
            // [6]mid=7 < timestamp=8: 0부터 mid까지 다 버림
            // left=mid+1=7, right=8, mid=7
            // [7]mid=8

            // ["alice": {1,2,3,4,5,6,7,8,9}] timestamp=2
            // left=0, right=8, mid=4
            // [4]mid=5 > timestamp=2: mid부터 length-1까지 다 버림
            // right=mid-1=3, left=0, mid=1
            // [1]mid=2

            // 문제
            // ["alice": {1,2,3,4,5,6,7,8,9}] timestamp=10
            // left=0, right=8, mid=4
            // [4]mid=5 < timestamp=10: 0부터 mid까지 다 버림
            // left=mid+1=5, right=8, mid=6
            // [6]mid=7 < timestamp=10: 0부터 mid까지 다 버림
            // left=mid+1=7, right=8, mid=7
            // [7]mid=8 < timestamp=10: 0부터 mid까지 다 버림
            // left=mid+1=8, right=8, mid=8
            // [8]mid=9
            // return 9

            // ["alice": {1,2,4,5,6,8,9}] timestamp=7
            // left=0, right=7, mid=3
            // [3]mid=5 < timestamp=7: 0부터 mid까지 다 버림
            // left=mid+1=4, right=7, mid=5
            // [5]mid=8 > timestamp=7: mid부터 length-1까지 다 버림
            // right=mid-1=4, left=4, mid=4
            // [4]mid=6
            // return 6

            return result;

        }else{
            return "";
        }


    }

}
