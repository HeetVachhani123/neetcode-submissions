// class Solution {
//     public int maxProduct(int[] nums) {
//         int ans = nums[0];

//         for (int i = 0; i < nums.length; i++) {
//             int currProduct = 1;           
//             for (int j = i; j < nums.length; j++) {
//                 currProduct = currProduct * nums[j];
//                 ans = Math.max(ans, currProduct);
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = nums[0];

        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < n; i++) {
            // Reset running product to 1 if we hit a 0
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix *= nums[i];
            suffix *= nums[n - 1 - i];

            maxProd = Math.max(maxProd, Math.max(prefix, suffix));
        }

        return maxProd;
    }
}