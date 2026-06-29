public class Solution {
    public String reorganizeString(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        
        // Find the character with the maximum frequency
        int maxCount = 0;
        int maxCharIdx = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                maxCharIdx = i;
            }
        }
        
        // If the most frequent character appears more than half the slots, 
        // it's mathematically impossible to rearrange without duplicates.
        if (maxCount > (s.length() + 1) / 2) {
            return "";
        }
        
        char[] res = new char[s.length()];
        int idx = 0;
        
        // Step 1: Place the most frequent character in alternating even slots
        while (counts[maxCharIdx] > 0) {
            res[idx] = (char) (maxCharIdx + 'a');
            idx += 2;
            counts[maxCharIdx]--;
        }
        
        // Step 2: Fill the remaining slots with the rest of the characters
        for (int i = 0; i < 26; i++) {
            while (counts[i] > 0) {
                if (idx >= res.length) {
                    idx = 1; // Switch to alternating odd slots once even ones are full
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                counts[i]--;
            }
        }
        
        return String.valueOf(res);
    }
}