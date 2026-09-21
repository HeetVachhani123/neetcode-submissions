public class Solution {
    int[] w;
    int total;

    public Solution(int[] w) {
        this.w = w;
        for (int weight : w) {
            total += weight;
        }
    }

    public int pickIndex() {
        double target = total * Math.random();
        int curSum = 0;
        for (int i = 0; i < w.length; i++) {
            curSum += w[i];
            if (curSum > target) {
                return i;
            }
        }
        return -1;
    }
}