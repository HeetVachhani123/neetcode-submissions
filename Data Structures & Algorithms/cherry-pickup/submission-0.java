
public class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        dp[0][0] = grid[0][0];

        for (int k = 1; k < 2 * n - 1; k++) {
            for (int r1 = Math.min(n - 1, k); r1 >= Math.max(0, k - n + 1); r1--) {
                for (int r2 = Math.min(n - 1, k); r2 >= Math.max(0, k - n + 1); r2--) {
                    int c1 = k - r1;
                    int c2 = k - r2;

                    if (grid[r1][c1] == -1 || grid[r2][c2] == -1) {
                        dp[r1][r2] = -1;
                        continue;
                    }

                    int res = dp[r1][r2]; 
                    if (r1 > 0) res = Math.max(res, dp[r1 - 1][r2]);
                    if (r2 > 0) res = Math.max(res, dp[r1][r2 - 1]);
                    if (r1 > 0 && r2 > 0) res = Math.max(res, dp[r1 - 1][r2 - 1]);

                    if (res < 0) {
                        dp[r1][r2] = -1;
                        continue;
                    }

                    res += grid[r1][c1];
                    if (r1 != r2) {
                        res += grid[r2][c2];
                    }
                    dp[r1][r2] = res;
                }
            }
        }

        return Math.max(0, dp[n - 1][n - 1]);
    }
}