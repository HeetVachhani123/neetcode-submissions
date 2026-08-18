class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;

        for (int n : nums)
            sum = (sum + n) % p;

        int need = (int) sum;
        if (need == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int ans = nums.length;
        long prefix = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;

            int target = (int) ((prefix - need + p) % p);

            if (map.containsKey(target))
                ans = Math.min(ans, i - map.get(target));

            map.put((int) prefix, i);
        }
        return ans == nums.length ? -1 : ans;
    }
}