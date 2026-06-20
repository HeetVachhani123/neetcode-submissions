public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int currentOnes = 0;
        
        for (int num : nums) {
            if (num == 1) {
                currentOnes++;
                if (currentOnes > maxOnes) {
                    maxOnes = currentOnes;
                }
            } else {
                currentOnes = 0;
            }
        }
        
        return maxOnes;
    }
}