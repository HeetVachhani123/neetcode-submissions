public class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];
        for (int i = 0; i < text.length(); i++) {
            counts[text.charAt(i) - 'a']++;
        }
        
        int min = counts['b' - 'a'];
        min = Math.min(min, counts['a' - 'a']);
        min = Math.min(min, counts['l' - 'a'] / 2);
        min = Math.min(min, counts['o' - 'a'] / 2);
        min = Math.min(min, counts['n' - 'a']);
        
        return min;
    }
}