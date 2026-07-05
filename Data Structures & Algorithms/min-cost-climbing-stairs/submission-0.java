public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // Base cases tracking the minimum cost to reach the last two steps
        int downTwo = cost[0];
        int downOne = cost[1];
        
        // Dynamically compute the minimum cost for each subsequent step
        for (int i = 2; i < cost.length; i++) {
            int current = cost[i] + Math.min(downOne, downTwo);
            downTwo = downOne;
            downOne = current;
        }
        
        // The top of the stairs can be reached from either of the last two steps
        return Math.min(downOne, downTwo);
    }
}