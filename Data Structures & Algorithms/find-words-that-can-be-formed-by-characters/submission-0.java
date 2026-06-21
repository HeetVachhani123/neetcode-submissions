public class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charCounts = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charCounts[chars.charAt(i) - 'a']++;
        }
        
        int totalLength = 0;
        
        for (String word : words) {
            int[] wordCounts = new int[26];
            boolean canForm = true;
            
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                wordCounts[idx]++;
                if (wordCounts[idx] > charCounts[idx]) {
                    canForm = false;
                    break;
                }
            }
            
            if (canForm) {
                totalLength += word.length();
            }
        }
        
        return totalLength;
    }
}