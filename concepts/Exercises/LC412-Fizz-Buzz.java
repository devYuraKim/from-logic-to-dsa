class Solution {

    public List<String> fizzBuzz(int n) {

        List<String> answer = new ArrayList<>();

        for(int i=1; i<n+1; i++){

            // 3,5 공배수는 더 깔끔하게 할 수 있을 것 같은데?
            if(i % 3 == 0 && i % 5 != 0) {
                // resultList[i] = "Fizz";
                answer.add("Fizz");
            }else if(i % 5 == 0 && i % 3 != 0){
                // resultList[i] = "Buzz";
                answer.add("Buzz");
            }else if (i % 5 == 0 && i % 3 == 0){
                // resultList[i] = "FizzBuzz";
                answer.add("FizzBuzz");
            } else {
                // 이거 as a String 어떻게 해?
                // resultList[i] = i;
                answer.add(String.valueOf(i));
            }
        }

        return answer;

        // 1. Array, List 차이 정리,
        // 2. List에 element add, get하는 거 정리
        // 3. if-else 논리 정리하기 ex) % 3 == 0 && % 5 == 0 부터 두면 아래에서 두 번 체크 안 해도 됨
        // 4. short circuit 논리 정리하기

    }
}

