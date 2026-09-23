public class Solution {
    public long distributeCandies(int n, int limit) {
        long res = 0;
        int maxA = Math.min(n, limit);
        for (int a = 0; a <= maxA; a++) {
            int maxB = Math.min(n - a, limit);
            for (int b = 0; b <= maxB; b++) {
                if (n - a - b <= limit) {
                    res++;
                }
            }
        }
        return res;
    }
}