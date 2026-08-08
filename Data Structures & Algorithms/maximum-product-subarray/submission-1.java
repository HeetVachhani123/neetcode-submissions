class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int currProduct = 1;           
            for (int j = i; j < nums.length; j++) {
                currProduct = currProduct * nums[j];
                ans = Math.max(ans, currProduct);
            }
        }
        return ans;
    }
}