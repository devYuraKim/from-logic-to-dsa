class TimeMap {

    class Pair {
        String value;
        int timestamp;
        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    //constructor
    public TimeMap() {
    }

    Map<String, List<Pair>> timeMap = new HashMap<>();

    // key-value는 map 구조인데?
    // 그러면 timestamp는 어디에 저장하지?
    // multiple values for the same key at different time stamps...
    // map의 key-value 구조를 이용하되, value에 [[String value, int timestamp]] 이 구조가 가능한가? Java는 안 될 것 같은데?
    // 여기까지가 8분 생각한 결과
    // Java에서는 그게 안 되니까 Class를 정의해야 한대...
    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }
        timeMap.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if(timeMap.containsKey(key)){
            List<Pair> pairList = timeMap.get(key);
            if(pairList.size()==0){
                return "";
            }else{
                for(int i=pairList.size()-1; i>=0; i--){
                    Pair curPair = pairList.get(i);
                    if(timestamp >= curPair.timestamp) return curPair.value;
                }
            }
        }

        return "";
    }
}