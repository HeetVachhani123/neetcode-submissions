public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        java.util.Set<Integer> set = new java.util.HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int longest = 0;
        
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                
                longest = Math.max(longest, currentStreak);
            }
        }
        
        return longest;
    }
}