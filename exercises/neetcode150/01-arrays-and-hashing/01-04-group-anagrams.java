import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Tue Nov 24 2026
//16'24''
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        //strs array에서 단어를 꺼냄
        //아까 한 것처럼 배열에 알파벳 개수를 저장
        //그 다음 분류를 어떻게 할까?
        //HashMap에 key와 value로 두면 어떨까?
        //key가 알파벳개수배열, value가 원래 단어
        //그래서 최종 결과는 각 key에 있는 value를 array로 출력

        HashMap<String, List<String>> output = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            String word = strs[i];
            int[] countArray = new int[26];
            for(int j=0; j<word.length(); j++){
                countArray[word.charAt(j)-'a']++;
            }
            String key = Arrays.toString(countArray);

            if (!output.containsKey(key)) {
                output.put(key, new ArrayList<>());
            }

            output.get(key).add(word);
        }


        return new ArrayList<>(output.values());

    }
}