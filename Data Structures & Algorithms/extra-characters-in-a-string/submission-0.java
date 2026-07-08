
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> dict = new HashSet<>();
        for (String word : dictionary) {
            dict.add(word);
        }
        
        // dp[i] represents the minimum extra characters left over for prefix s[0...i-1]
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            // Base choice: Treat the current character s[i-1] as an extra character
            dp[i] = dp[i - 1] + 1;
            
            // Try all possible substrings s[j...i-1] ending at the current index
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (dict.contains(substring)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        
        return dp[n];
    }
}