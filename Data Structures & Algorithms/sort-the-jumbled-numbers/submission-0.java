class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            int value = nums[i], mapped = 0, place = 1;
            if (value == 0)
                mapped = mapping[0];
            while (value > 0) {
                mapped += mapping[value % 10] * place;
                value /= 10;
                place *= 10;
            }
            pairs[i] = new int[] {mapped, i};
        }
        Arrays.sort(pairs,
            (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        int[] result = new int[n];
        for (int i = 0; i < n; i++) result[i] = nums[pairs[i][1]];
        return result;
    }
}
