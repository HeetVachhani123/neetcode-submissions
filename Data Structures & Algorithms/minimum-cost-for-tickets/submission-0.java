class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        boolean[] isTravelDay = new boolean[lastDay + 1];
        
        // Mark all days that require travel
        for (int day : days) {
            isTravelDay[day] = true;
        }
        
        int[] dp = new int[lastDay + 1];
        
        for (int i = 1; i <= lastDay; i++) {
            // If we don't travel today, the cost remains the same as yesterday
            if (!isTravelDay[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            
            // Calculate the 3 possible choices:
            // 1. Buy a 1-day pass for today
            int option1 = dp[i - 1] + costs[0];
            
            // 2. Buy a 7-day pass that covers up to today
            int option2 = dp[Math.max(0, i - 7)] + costs[1];
            
            // 3. Buy a 30-day pass that covers up to today
            int option3 = dp[Math.max(0, i - 30)] + costs[2];
            
            // Take the minimum cost among all three choices
            dp[i] = Math.min(option1, Math.min(option2, option3));
        }
        
        return dp[lastDay];
    }
}