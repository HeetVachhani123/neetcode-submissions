public class Solution {
    public long distributeCandies(int n, int limit) {
        int[] C3 = {1, 3, 3, 1};
        long res = 0;
        for (int j = 0; j < 4; j++) {
            long m = n - j * (limit + 1);
            if (m < 0) continue;
            long ways = (m + 2) * (m + 1) / 2;
            int sign = (j % 2 == 0) ? 1 : -1;
            res += sign * C3[j] * ways;
        }
        return res;
    }
}