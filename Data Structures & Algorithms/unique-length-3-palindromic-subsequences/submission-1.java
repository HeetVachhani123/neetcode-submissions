public class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<String> res = new HashSet<>();

        for (int i = 0; i < s.length() - 2; i++) {
            for (int j = i + 1; j < s.length() - 1; j++) {
                for (int k = j + 1; k < s.length(); k++) {
                    if (s.charAt(i) != s.charAt(k)) {
                        continue;
                    }
                    res.add("" + s.charAt(i) + s.charAt(j) + s.charAt(k));
                }
            }
        }
        return res.size();
    }
}