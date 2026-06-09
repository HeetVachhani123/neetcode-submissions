class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicate = -1;
        int missing = -1;
        
        // Step 1: Find the duplicate by marking indices as negative
        for (int num : nums) {
            int val = Math.abs(num);
            if (nums[val - 1] < 0) {
                duplicate = val;
            } else {
                nums[val - 1] *= -1;
            }
        }
        
        // Step 2: Find the missing number (the index that remains positive)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }
        
        return new int[]{duplicate, missing};
    }
}