public class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int totalElements = n * n;
        int[] counts = new int[totalElements + 1];
        
        // Count frequencies of each number in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                counts[grid[i][j]]++;
            }
        }
        
        int repeated = -1;
        int missing = -1;
        
        // Identify the repeated (count == 2) and missing (count == 0) values
        for (int i = 1; i <= totalElements; i++) {
            if (counts[i] == 2) {
                repeated = i;
            } else if (counts[i] == 0) {
                missing = i;
            }
        }
        
        return new int[]{repeated, missing};
    }
}