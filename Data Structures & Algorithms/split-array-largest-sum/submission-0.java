public class Solution {
    public int splitArray(int[] nums, int k) {
        int maxElement = 0;
        int totalSum = 0;
        
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
            totalSum += num;
        }
        
        int left = maxElement;
        int right = totalSum;
        int result = right;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canSplit(nums, k, mid)) {
                result = mid;
                right = mid - 1; // Try to find a smaller valid maximum sum
            } else {
                left = mid + 1;  // Increase the allowed maximum sum
            }
        }
        
        return result;
    }
    
    private boolean canSplit(int[] nums, int k, int maxSubarraySum) {
        int subarrayCount = 1;
        int currentSum = 0;
        
        for (int num : nums) {
            if (currentSum + num > maxSubarraySum) {
                subarrayCount++;
                currentSum = num;
                if (subarrayCount > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        
        return true;
    }
}