public class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) continue;

                boolean found = false;
                for (int col = 0; col < n; col++) {
                    if (col != c && grid[r][col] == 1) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    for (int row = 0; row < m; row++) {
                        if (row != r && grid[row][c] == 1) {
                            found = true;
                            break;
                        }
                    }
                }

                if (found) res++;
            }
        }

        return res;
    }
}