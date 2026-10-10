public class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length, res = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                seen.add(nums[j]);
                if (seen.size() > k) {
                    break;
                }
                if (seen.size() == k) {
                    res++;
                }
            }
        }
        return res;
    }
}