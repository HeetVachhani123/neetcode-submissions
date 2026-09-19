public class Solution {
    public int prefixCount(String[] words, String pref) {
        int N = pref.length(), res = 0;

        for (String w : words) {
            if (w.length() < N) continue;
            int inc = 1;
            for (int i = 0; i < N; i++) {
                if (w.charAt(i) != pref.charAt(i)) {
                    inc = 0;
                    break;
                }
            }
            res += inc;
        }
        return res;
    }
}