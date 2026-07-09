class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        
        // Step 1: Pad the original array with 1 at both ends to handle out-of-bounds cleanly
        int[] paddedNums = new int[n + 2];
        paddedNums[0] = 1;
        paddedNums[n + 1] = 1;
        System.arraycopy(nums, 0, paddedNums, 1, n);
        
        // dp[left][right] stores the max coins obtained by bursting all balloons 
        // in the sub-array from index 'left' to 'right' (inclusive)
        int[][] dp = new int[n + 2][n + 2];
        
        // Step 2: Build the solutions bottom-up, starting from smaller sub-arrays (window lengths)
        for (int windowLength = 1; windowLength <= n; windowLength++) {
            for (int left = 1; left <= n - windowLength + 1; left++) {
                int right = left + windowLength - 1;
                
                // Step 3: Find the optimal balloon to burst LAST in this current window
                for (int lastToBurst = left; lastToBurst <= right; lastToBurst++) {
                    
                    // Coins gained from bursting 'lastToBurst' balloon at the very end
                    int coinsFromLast = paddedNums[left - 1] * paddedNums[lastToBurst] * paddedNums[right + 1];
                    
                    // Total coins = coins from left sub-window + coins from right sub-window + coins from last balloon
                    int totalCoins = dp[left][lastToBurst - 1] + coinsFromLast + dp[lastToBurst + 1][right];
                    
                    // Track the maximum coins possible for this window
                    dp[left][right] = Math.max(dp[left][right], totalCoins);
                }
            }
        }
        
        // Return the max coins for the entire original array range [1...n]
        return dp[1][n];
    }
}