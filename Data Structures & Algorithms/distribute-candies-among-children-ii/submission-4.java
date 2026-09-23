public class Solution {
    public long distributeCandies(int n, int limit) {
        long res = 0;
        for (int a = 0, aMax = Math.min(n, limit); a <= aMax; a++) {
            int bMax = Math.min(n - a, limit);
            int bMin = Math.max(0, n - a - limit);
            if (bMax >= bMin) {
                res += (long)(bMax - bMin + 1);
            }
        }
        return res;
    }
}