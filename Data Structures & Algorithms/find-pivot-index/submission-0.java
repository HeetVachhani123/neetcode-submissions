class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        // Step 1: Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        // Step 2: Iterate through the array to find the pivot index
        for (int i = 0; i < nums.length; i++) {
            // Right sum is totalSum minus leftSum minus current element
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i; // Leftmost pivot found
            }
            leftSum += nums[i];
        }
        
        return -1; // No pivot index found
    }
}