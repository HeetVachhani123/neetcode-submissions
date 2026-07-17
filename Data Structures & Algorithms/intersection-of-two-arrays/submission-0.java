class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Track unique elements from the first array
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        
        // Find elements present in both arrays (deduplicated)
        Set<Integer> intersectionSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                intersectionSet.add(num);
            }
        }
        
        // Convert the intersection set into a standard primitive array
        int[] result = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            result[index++] = num;
        }
        
        return result;
    }
}