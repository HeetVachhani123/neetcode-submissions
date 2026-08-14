public class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];

        for (int pos = 0; pos < n; pos++) {
            for (int i = 0; i < n; i++) {
                if (boxes.charAt(i) == '1') {
                    res[pos] += Math.abs(pos - i);
                }
            }
        }
        return res;
    }
}