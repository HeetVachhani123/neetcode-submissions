
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        // Add a copy of the current subset to our final result list
        result.add(new ArrayList<>(currentSubset));
        
        // Iterate through the remaining elements to form new subsets
        for (int i = start; i < nums.length; i++) {
            // Include the current element
            currentSubset.add(nums[i]);
            
            // Move on to the next element
            backtrack(result, currentSubset, nums, i + 1);
            
            // Backtrack: remove the recently added element to explore other paths
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}