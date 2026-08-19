class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int res = 0, n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
            }
        }

        int satisfied = res;
        for (int i = 0; i <= n - minutes; i++) {
            int cur = 0;
            for (int j = i; j < i + minutes; j++) {
                if (grumpy[j] == 1) {
                    cur += customers[j];
                }
            }
            res = Math.max(res, satisfied + cur);
        }
        return res;
    }
}