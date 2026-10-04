public class Solution {
    private Set<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new HashSet<>();
        List<Integer> perm = new ArrayList<>();
        backtrack(nums, perm);
        return new ArrayList<>(res);
    }

    private void backtrack(int[] nums, List<Integer> perm) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MIN_VALUE) {
                int temp = nums[i];
                perm.add(nums[i]);
                nums[i] = Integer.MIN_VALUE;
                backtrack(nums, perm);
                nums[i] = temp;
                perm.remove(perm.size() - 1);
            }
        }
    }
}