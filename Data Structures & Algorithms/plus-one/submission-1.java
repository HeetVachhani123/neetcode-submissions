class Solution {
    public int[] plusOne(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum = sum + arr[i];
        }
        sum = sum + 1;
        int m = sum.length();
        int[] ans = new int[m];
        for(int i=0; i<m; i++){
            ans[i] = sum;
        }
        return sum;
        return ans;
    }
}
