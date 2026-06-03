class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Array to store the net change of passengers at each location
        // The maximum location constraint is 1000, so size 1001 covers 0 to 1000.
        int[] timestamp = new int[1001];
        
        // 1. Record the passenger pick-ups and drop-offs
        for (int[] trip : trips) {
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];
            
            timestamp[start] += passengers; // Passengers board
            timestamp[end] -= passengers;   // Passengers leave
        }
        
        // 2. Track the current capacity during the journey
        int currentPassengers = 0;
        for (int i = 0; i <= 1000; i++) {
            currentPassengers += timestamp[i];
            
            // If at any point we exceed capacity, return false
            if (currentPassengers > capacity) {
                return false;
            }
        }
        
        // If we finish the route without exceeding capacity
        return true;
    }
}