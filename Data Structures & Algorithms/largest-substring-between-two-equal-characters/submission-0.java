class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] firstIndex = new int[26];
        for (int i = 0; i < 26; i++) {
            firstIndex[i] = -1;
        }
        
        int maxLength = -1;
        
        for (int i = 0; i < s.length(); i++) {
            int charIdx = s.charAt(i) - 'a';
            
            if (firstIndex[charIdx] == -1) {
                firstIndex[charIdx] = i;
            } else {
                int currentLength = i - firstIndex[charIdx] - 1;
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        
        return maxLength;
    }
}