class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int mask = 0, count = words.length;
        for (char c : allowed.toCharArray()) mask |= 1 << (c - 'a');
        for (String w : words) {
            for (char c : w.toCharArray()) {
                if ((mask & (1 << (c - 'a'))) == 0) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}