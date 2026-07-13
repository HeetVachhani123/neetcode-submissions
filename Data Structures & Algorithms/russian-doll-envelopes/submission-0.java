class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }      

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]); // Height descending
            }
            return Integer.compare(a[0], b[0]);     // Width ascending
        });        

        int[] dp = new int[envelopes.length];
        int len = 0;
        
        for (int[] envelope : envelopes) {
            int height = envelope[1];
            
            int idx = Arrays.binarySearch(dp, 0, len, height);
            
            if (idx < 0) {
                idx = -(idx + 1);
            }
            
            dp[idx] = height;
            
            if (idx == len) {
                len++;
            }
        }      
        return len;
    }
}