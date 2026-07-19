class Solution {
    public boolean makeEqual(String[] words) {
        int[] charCounts = new int[26];
        int totalWords = words.length;
        
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                charCounts[word.charAt(i) - 'a']++;
            }
        }
        
        for (int count : charCounts) {
            if (count % totalWords != 0) {
                return false;
            }
        }
        
        return true;
    }
}