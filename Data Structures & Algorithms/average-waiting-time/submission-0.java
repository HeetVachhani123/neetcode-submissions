public class Solution {
    public double averageWaitingTime(int[][] customers) {
        long totalWaitingTime = 0;
        long chefFreeTime = 0;
        
        for (int[] customer : customers) {
            int arrival = customer[0];
            int prepTime = customer[1];
            
            chefFreeTime = Math.max(chefFreeTime, arrival) + prepTime;
            totalWaitingTime += (chefFreeTime - arrival);
        }
        
        return (double) totalWaitingTime / customers.length;
    }
}