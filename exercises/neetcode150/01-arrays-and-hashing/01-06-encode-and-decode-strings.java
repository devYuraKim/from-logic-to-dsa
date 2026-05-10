// 8:56
class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String word: strs){
            sb.append(word.length());
            sb.append("#");
            sb.append(word);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {

        List<String> output = new ArrayList<>();
        int startIndex = 0;

        while(startIndex < str.length()){

            int separatorIndex = str.indexOf("#", startIndex);

            int wordLength = Integer.parseInt(str.substring(startIndex, separatorIndex));
            String word = str.substring(separatorIndex+1, separatorIndex+1+wordLength);
            output.add(word);

            startIndex = separatorIndex+1+wordLength;

        }

        return output;

    }
}
