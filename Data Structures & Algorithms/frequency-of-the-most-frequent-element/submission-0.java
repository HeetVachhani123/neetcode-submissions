public class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1;

        for (int i = 0; i < nums.length; i++) {
            int j = i - 1;
            long tmpK = k;

            while (j >= 0 && (tmpK - (nums[i] - nums[j])) >= 0) {
                tmpK -= (nums[i] - nums[j]);
                j--;
            }
            res = Math.max(res, i - j);
        }
        return res;
    }
}