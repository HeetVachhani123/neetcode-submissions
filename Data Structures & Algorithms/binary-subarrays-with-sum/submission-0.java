public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length, res = 0;

        for (int i = 0; i < n; i++) {
            int curSum = 0;
            for (int j = i; j < n; j++) {
                curSum += nums[j];
                if (curSum == goal) {
                    res++;
                }
            }
        }
        return res;
    }
}