public class Solution {
    public int longestPalindrome(String s) {
        int[] charCounts = new int[128]; // Covers all ASCII characters (uppercase and lowercase)
        
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i)]++;
        }
        
        int length = 0;
        boolean hasOddCount = false;
        
        for (int count : charCounts) {
            // Add the maximum even portion of this character's frequency
            length += (count / 2) * 2;
            
            // Check if there is a remainder/odd character left over
            if (count % 2 != 0) {
                hasOddCount = true;
            }
        }
        
        // If any odd character frequencies exist, we can place exactly one in the center
        if (hasOddCount) {
            length += 1;
        }
        
        return length;
    }
}