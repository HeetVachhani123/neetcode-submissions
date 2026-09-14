public class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int maxi = 0, cnt = 0;
            for (int j = i + 1; j < n; j++) {
                if (Math.min(heights[i], heights[j]) > maxi) {
                    cnt++;
                }
                maxi = Math.max(maxi, heights[j]);
            }
            res[i] = cnt;
        }
        return res;
    }
}