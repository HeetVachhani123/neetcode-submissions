public class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int maxf = count.values().stream().max(Integer::compare).orElse(0);
        int[] minOps = new int[maxf + 1];
        minOps[1] = Integer.MAX_VALUE;

        for (int i = 2; i <= maxf; i++) {
            minOps[i] = minOps[i - 2];
            if (i - 3 >= 0) {
                minOps[i] = Math.min(minOps[i], minOps[i - 3]);
            }
            if (minOps[i] != Integer.MAX_VALUE) {
                minOps[i] += 1;
            }
        }

        int res = 0;
        for (int cnt : count.values()) {
            int op = minOps[cnt];
            if (op == Integer.MAX_VALUE) {
                return -1;
            }
            res += op;
        }

        return res;
    }
}