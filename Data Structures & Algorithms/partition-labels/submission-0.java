public class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        int[] lastIndices = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndices[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndices[s.charAt(i) - 'a']);
            
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}