public class Solution {
    public int numDecodings(String s) {
        // Edge case: an empty string or a string starting with '0' cannot be decoded
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        // dp[i] stores the number of ways to decode the substring s[0...i-1]
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1; // An empty string has 1 valid way to be decoded (doing nothing)
        dp[1] = 1; // We already checked that s.charAt(0) != '0', so there is 1 valid way

        for (int i = 2; i <= n; i++) {
            // Check single-digit decoding (the character at index i-1)
            char singleChar = s.charAt(i - 1);
            if (singleChar != '0') {
                dp[i] += dp[i - 1];
            }

            // Check two-digit decoding (the substring from index i-2 to i)
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}