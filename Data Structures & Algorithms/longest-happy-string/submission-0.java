public class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        
        // Array to hold counts and their corresponding characters
        int[] counts = {a, b, c};
        char[] letters = {'a', 'b', 'c'};
        
        while (true) {
            // Find the indices of the largest and second largest counts
            int first = -1;
            int second = -1;
            
            for (int i = 0; i < 3; i++) {
                if (first == -1 || counts[i] > counts[first]) {
                    second = first;
                    first = i;
                } else if (second == -1 || counts[i] > counts[second]) {
                    second = i;
                }
            }
            
            // If the highest remaining count is 0, we can't add anything else
            if (counts[first] == 0) {
                break;
            }
            
            int len = sb.length();
            // Check if adding the largest character would create 3 in a row
            if (len >= 2 && sb.charAt(len - 1) == letters[first] && sb.charAt(len - 2) == letters[first]) {
                // We cannot use the largest character; check if we can use the second largest
                if (second == -1 || counts[second] == 0) {
                    break; // No other distinct valid characters available
                }
                
                sb.append(letters[second]);
                counts[second]--;
            } else {
                // It is safe to use the character with the maximum count
                sb.append(letters[first]);
                counts[first]--;
            }
        }
        
        return sb.toString();
    }
}