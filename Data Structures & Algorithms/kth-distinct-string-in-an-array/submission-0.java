public class Solution {
    public String kthDistinct(String[] arr, int k) {
        java.util.Map<String, Integer> counts = new java.util.HashMap<>();
        
        for (String str : arr) {
            counts.put(str, counts.getOrDefault(str, 0) + 1);
        }
        
        for (String str : arr) {
            if (counts.get(str) == 1) {
                k--;
                if (k == 0) {
                    return str;
                }
            }
        }
        
        return "";
    }
}