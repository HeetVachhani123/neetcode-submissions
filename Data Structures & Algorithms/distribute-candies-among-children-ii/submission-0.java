public class Solution {
    public long distributeCandies(int n, int limit) {
        long res = 0;
        for (int a = 0; a <= limit; a++) {
            for (int b = 0; b <= limit; b++) {
                for (int c = 0; c <= limit; c++) {
                    if (a + b + c == n) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}