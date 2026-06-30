public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Step 1: Mark visited indices by negating the value at that index
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        // Step 2: Any index that remains positive means its corresponding number was never seen
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        
        return result;
    }
}