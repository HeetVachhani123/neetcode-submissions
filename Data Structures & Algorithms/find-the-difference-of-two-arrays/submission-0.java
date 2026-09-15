public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> res1 = new HashSet<>();
        Set<Integer> res2 = new HashSet<>();

        for (int num1 : nums1) {
            boolean found = false;
            for (int num2 : nums2) {
                if (num1 == num2) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                res1.add(num1);
            }
        }

        for (int num2 : nums2) {
            boolean found = false;
            for (int num1 : nums1) {
                if (num1 == num2) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                res2.add(num2);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(res1));
        result.add(new ArrayList<>(res2));
        return result;
    }
}