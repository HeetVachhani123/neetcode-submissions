
public class Solution {
    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        // Initialize the tracking array with maximum possible values
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        
        for (String word : words) {
            int[] charFreq = new int[26];
            // Count frequencies of characters in the current word
            for (int i = 0; i < word.length(); i++) {
                charFreq[word.charAt(i) - 'a']++;
            }
            
            // Keep the minimum frequency found for each character across all words
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], charFreq[i]);
            }
        }
        
        List<String> result = new ArrayList<>();
        // Collect characters that appeared in all words
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(String.valueOf((char) (i + 'a')));
                minFreq[i]--;
            }
        }
        
        return result;
    }
}