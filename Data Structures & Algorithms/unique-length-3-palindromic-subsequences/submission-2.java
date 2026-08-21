public class Solution {
    public int countPalindromicSubsequence(String s) {
        int res = 0;
        for (char ends = 'a'; ends <= 'z'; ends++) {
            for (char mid = 'a'; mid <= 'z'; mid++) {
                String seq = "" + ends + mid + ends;
                int idx = 0, found = 0;
                for (char c : s.toCharArray()) {
                    if (seq.charAt(idx) == c) {
                        idx++;
                        if (idx == 3) {
                            found = 1;
                            break;
                        }
                    }
                }
                res += found;
            }
        }
        return res;
    }
}