
> 내가 잘못한 것들
> 1. count 안 넣고 char 자체를 넣음
> 2. array → string 방법 모름
> 3. HashMap 함수 이름 틀림
> 4. return 안 함
> 5. Map<String, String> → Map<String, List<String>>
> 6. `new ArrayList<>(Arrays.asList(strs[i]))`, `new ArrayList<>(wordMap.values())` 이해 못 함


### 2. array → string 방법 모름
`String key = Arrays.toString(arr)`은 그냥 외우기 (자주 나옴)

### 3. HashMap 함수 이름 틀림
→ Map 기본 5개는 자동화해야 함     
`put`     
`get`      
`containsKey`     
`putIfAbsent`     
`values`   

> 특히   
> (1) `map.putIfAbsent(key, new ArrayList<>());`    
> (2) `map.get(key).add(value);`


### 6-1. `new ArrayList<>(Arrays.asList(strs[i]))`
단순히 `wordMap.put(key, strs[i])`를 할 수 없는 이유는 **데이터 타입의 불일치** 때문입니다.

* **이유:** `wordMap`의 가치(Value)는 `String` 하나가 아니라, `List<String>`(주머니)입니다.
* **문제:** 처음 보는 아나그램 키가 등장했을 때, 빈 주머니를 먼저 만들어줘야 나중에 다른 단어들을 추가로 담을 수 있습니다.
* **해설:** * `Arrays.asList(strs[i])`: 단어 한 개가 들어있는 **'수정 불가능한'** 임시 리스트를 만듭니다.
    * `new ArrayList<>(...)`: 그 임시 리스트를 복사해서 **'나중에 단어를 더 추가할 수 있는(Mutable)'** 진짜 주머니로 변환합니다.
* **비유:** 서랍(Map)에 물건을 그냥 던져 넣는 게 아니라, 먼저 **바구니(List)**를 하나 사고 그 안에 첫 번째 물건을 넣어서 서랍에 넣는 과정입니다.

### 6-2. `new ArrayList<>(wordMap.values())`
`return wordMap.values();`를 하면 에러가 나는 이유는 Java의 **반환 타입(Return Type)** 약속 때문입니다.

* **이유:** 리트코드 문제의 반환 타입은 `List<List<String>>`입니다. 그런데 `wordMap.values()`가 반환하는 타입은 `Collection<List<String>>`이라는 조금 다른 형태입니다.
* **문제:** Java 입장에서 `Collection`은 `List`보다 더 큰 개념이라, "리스트를 주기로 약속했으면서 왜 컬렉션을 줘?"라며 컴파일 에러를 냅니다.
* **해설:** 그래서 `new ArrayList<>(...)`를 통해 '컬렉션 데이터를 리스트 형태로 변환(Casting/Wrapping)'해주는 과정이 필요합니다.

---