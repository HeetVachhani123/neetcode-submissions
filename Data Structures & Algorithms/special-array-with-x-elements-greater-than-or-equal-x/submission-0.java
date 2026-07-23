class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            int count = n - i;
            if (nums[i] >= count && (i == 0 || nums[i - 1] < count)) {
                return count;
            }
        }     
        return -1;
    }
}