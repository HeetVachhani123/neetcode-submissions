class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        List<Integer> lst = new ArrayList<>(set);
        for(int i=0; i<lst.size(); i++){
            nums[i] = lst.get(i);
        }
        return lst.size();
    }
}