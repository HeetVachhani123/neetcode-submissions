class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int changesForPattern0 = 0;
        
        for (int i = 0; i < n; i++) {
            // Pattern 0 expects '0' at even indices and '1' at odd indices
            char expectedChar = (i % 2 == 0) ? '0' : '1';
            
            if (s.charAt(i) != expectedChar) {
                changesForPattern0++;
            }
        }
        
        // The operations needed for the alternative pattern (starting with '1') 
        // is simply the total length minus the operations for Pattern 0.
        return Math.min(changesForPattern0, n - changesForPattern0);
    }
}