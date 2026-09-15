public class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isPrefixAndSuffix(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }

        int j = 0;
        for (int i = s2.length() - s1.length(); i < s2.length(); i++) {
            if (s1.charAt(j) != s2.charAt(i)) return false;
            j++;
        }

        return true;
    }
}