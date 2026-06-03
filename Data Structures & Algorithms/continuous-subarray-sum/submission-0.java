class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Map to store the first occurrence of a specific remainder
        // Key: remainder, Value: index
        Map<Integer, Integer> remainderMap = new HashMap<>();
        
        // Initialize with remainder 0 at index -1 to handle valid subarrays starting at index 0
        remainderMap.put(0, -1);
        
        long prefixSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            
            int remainder = (int) (prefixSum % k);
            
            // If the remainder has been seen before
            if (remainderMap.containsKey(remainder)) {
                // Check if the subarray length is at least 2
                if (i - remainderMap.get(remainder) >= 2) {
                    return true;
                }
            } else {
                // Only store the first occurrence of the remainder
                remainderMap.put(remainder, i);
            }
        }
        
        return false;
    }
}