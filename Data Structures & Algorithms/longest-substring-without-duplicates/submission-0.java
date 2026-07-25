
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[256];
        Arrays.fill(lastSeen, -1);
        
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If the character was seen inside our current window, shrink the window from the left
            if (lastSeen[currentChar] >= left) {
                left = lastSeen[currentChar] + 1;
            }
            
            // Update the last seen position of the current character
            lastSeen[currentChar] = right;
            
            // Calculate current window size
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}