
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        
        // A valid IP address has 4 segments, each containing 1 to 3 digits.
        // Therefore, the string length must be between 4 and 12 characters.
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(String s, int startIndex, List<String> currentSegments, List<String> result) {
        // Base case: If we have successfully isolated 4 segments
        if (currentSegments.size() == 4) {
            // If we have also consumed the entire string, it's a valid combination
            if (startIndex == s.length()) {
                result.add(String.join(".", currentSegments));
            }
            return;
        }
        
        // Try slicing a segment of length 1, 2, or 3 digits
        for (int len = 1; len <= 3; len++) {
            // Prevent going out of bounds
            if (startIndex + len > s.length()) {
                break;
            }
            
            String segment = s.substring(startIndex, startIndex + len);
            
            // Validate the current segment before diving deeper
            if (isValid(segment)) {
                currentSegments.add(segment);
                
                // Move forward to find the next segment
                backtrack(s, startIndex + len, currentSegments, result);
                
                // Backtrack: remove the last segment to explore other split options
                currentSegments.remove(currentSegments.size() - 1);
            }
        }
    }
    
    private boolean isValid(String segment) {
        // Rule 1: No leading zeros allowed (e.g., "01", "00" are invalid, but "0" is valid)
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false;
        }
        
        // Rule 2: The numeric value must be between 0 and 255 inclusive
        int value = Integer.parseInt(segment);
        return value >= 0 && value <= 255;
    }
}