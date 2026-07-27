class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int x : nums) sum += x;

        boolean possible = false;
        for (int k = 1; k <= n / 2; k++) {
            if ((sum * k) % n == 0) {
                possible = true;
                break;
            }
        }
        if (!possible) return false;

        int m = n / 2;
        int[] left = Arrays.copyOfRange(nums, 0, m);
        int[] right = Arrays.copyOfRange(nums, m, n);

        Map<Integer, Set<Integer>> map = new HashMap<>();

        int lSize = left.length;
        for (int mask = 1; mask < (1 << lSize); mask++) {
            int s = 0, c = 0;
            for (int i = 0; i < lSize; i++) {
                if ((mask & (1 << i)) != 0) {
                    s += left[i];
                    c++;
                }
            }
            map.computeIfAbsent(c, k -> new HashSet<>()).add(s);
        }

        int rSize = right.length;
        for (int mask = 1; mask < (1 << rSize); mask++) {
            int s = 0, c = 0;
            for (int i = 0; i < rSize; i++) {
                if ((mask & (1 << i)) != 0) {
                    s += right[i];
                    c++;
                }
            }

            if ((sum * c) % n == 0 && s == (sum * c) / n)
                return true;

            for (int lc = 1; lc <= lSize; lc++) {
                int total = lc + c;
                if (total >= n) continue;
                if ((sum * total) % n != 0) continue;

                int target = (sum * total) / n - s;
                Set<Integer> set = map.get(lc);
                if (set != null && set.contains(target))
                    return true;
            }
        }

        for (Map.Entry<Integer, Set<Integer>> e : map.entrySet()) {
            int c = e.getKey();
            if ((sum * c) % n != 0) continue;
            if (e.getValue().contains((sum * c) / n))
                return true;
        }

        return false;
    }
}