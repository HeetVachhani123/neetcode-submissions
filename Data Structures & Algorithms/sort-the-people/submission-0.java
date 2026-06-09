
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        // Step 1: Use a TreeMap that automatically sorts keys in descending order
        Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }
        
        // Step 2: Extract the values into the result array
        String[] result = new String[names.length];
        int index = 0;
        for (String name : map.values()) {
            result[index++] = name;
        }       
        return result;
    }
}