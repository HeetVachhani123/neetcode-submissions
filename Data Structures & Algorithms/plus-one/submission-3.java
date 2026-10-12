class Solution {
    public int[] plusOne(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum = sum + arr[i];
        }
        sum = sum + 1;
        return sum;
    }
}
