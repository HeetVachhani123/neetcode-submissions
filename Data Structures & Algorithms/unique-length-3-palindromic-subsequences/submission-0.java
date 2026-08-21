public class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<String> res = new HashSet<>();
        rec(s, 0, "", res);
        return res.size();
    }

    private void rec(String s, int i, String cur, Set<String> res) {
        if (cur.length() == 3) {
            if (cur.charAt(0) == cur.charAt(2)) {
                res.add(cur);
            }
            return;
        }
        if (i == s.length()) {
            return;
        }
        rec(s, i + 1, cur, res);
        rec(s, i + 1, cur + s.charAt(i), res);
    }
}