class Solution {
    public int maxDifference(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        
        for (int count : counts) {
            if (count > 0) {
                if (count % 2 != 0) {
                    maxOdd = Math.max(maxOdd, count);
                } else {
                    minEven = Math.min(minEven, count);
                }
            }
        }
        
        return maxOdd - minEven;
    }
}