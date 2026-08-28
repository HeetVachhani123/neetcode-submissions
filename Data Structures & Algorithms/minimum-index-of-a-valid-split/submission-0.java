public class Solution {
    public int minimumIndex(List<Integer> nums) {
        int majority = 0, count = 0;
        for (int num : nums) {
            if (count == 0) majority = num;
            count += (majority == num) ? 1 : -1;
        }

        int leftCnt = 0, rightCnt = 0;
        for (int num : nums) {
            if (num == majority) rightCnt++;
        }

        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == majority) {
                leftCnt++;
                rightCnt--;
            }

            int leftLen = i + 1;
            int rightLen = n - i - 1;

            if (2 * leftCnt > leftLen && 2 * rightCnt > rightLen) {
                return i;
            }
        }

        return -1;
    }
}