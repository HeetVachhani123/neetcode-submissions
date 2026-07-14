class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int r = 0; r < rows; r++) {
            if (grid[r][0] == 1) {
                floodFill(grid, r, 0);
            }
            if (grid[r][cols - 1] == 1) {
                floodFill(grid, r, cols - 1);
            }
        }
        
        for (int c = 0; c < cols; c++) {
            if (grid[0][c] == 1) {
                floodFill(grid, 0, c);
            }
            if (grid[rows - 1][c] == 1) {
                floodFill(grid, rows - 1, c);
            }
        }
        
        int enclaveCount = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    enclaveCount++;
                }
            }
        }
        
        return enclaveCount;
    }
    
    private void floodFill(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return;
        }
        
        grid[r][c] = 0;
        
        floodFill(grid, r + 1, c);
        floodFill(grid, r - 1, c);
        floodFill(grid, r, c + 1);
        floodFill(grid, r, c - 1);
    }
}