// Sun May 17 2026
// 10'58''
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();

        int [] charCount1 = new int [26];
        for(int i=0; i<len1; i++){
            charCount1[s1.charAt(i)-'a'] += 1;
        }

        for(int j=0; j<=len2-len1; j++){
            int [] charCount2 = new int [26];
            String sub = s2.substring(j, j+len1);
            for(int k=0; k<len1; k++){
                charCount2[sub.charAt(k)-'a'] += 1;
            }
            if (Arrays.equals(charCount1, charCount2)) {
                return true;
            }
        }

        return false;
    }
}

// abc -> 1#1#1#0#0#....
// lecabee
// lec ->
// eca ->
// cab ->
//