public class Solution {
    public long distributeCandies(int n, int limit) {
        long res = 0;
        int maxA = Math.min(n, limit);
        for (int a = 0; a <= maxA; a++) {
            int rem = n - a;
            if (rem <= 2L * limit) {
                int hi = Math.min(rem, limit);
                int lo = Math.max(0, rem - limit);
                res += (hi - lo + 1);
            }
        }
        return res;
    }
}