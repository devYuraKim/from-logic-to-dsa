//Tue Nov 24 2026
//12'10''
import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        //알파벳마다 고유의 숫자가 있을까?
        //있다면 배열을 만들어서 index 0에 a의 개수, 1에 b의 개수를 넣고 이걸 다시 string으로 만들어서 둘이 같은지 비교할 수 없나

        int[] arrayS = new int[26];
        int[] arrayT = new int[26];

        for(int i=0; i<s.length(); i++){
            arrayS[s.charAt(i)-'a']++;
        }

        for(int i=0; i<t.length(); i++){
            arrayT[t.charAt(i)-'a']++;
        }

        return Arrays.equals(arrayS, arrayT);
    }
}