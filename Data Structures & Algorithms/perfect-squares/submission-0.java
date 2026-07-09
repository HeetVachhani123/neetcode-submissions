class Solution {
    public int numSquares(int n) {
        // dp[i] will store the least number of perfect square numbers that sum to i
        int[] dp = new int[n + 1];
        
        // Initialize the table with a maximum possible value
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // Base case: 0 requires 0 perfect squares
        dp[0] = 0;
        
        // Build up solutions for all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // Try all perfect squares less than or equal to i
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }      
        return dp[n];
    }
}