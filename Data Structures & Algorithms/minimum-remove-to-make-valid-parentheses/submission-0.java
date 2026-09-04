public class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder res = new StringBuilder();
        int cnt = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                res.append(c);
                cnt++;
            } else if (c == ')' && cnt > 0) {
                res.append(c);
                cnt--;
            } else if (c != ')') {
                res.append(c);
            }
        }

        StringBuilder filtered = new StringBuilder();
        for (int i = res.length() - 1; i >= 0; i--) {
            char c = res.charAt(i);
            if (c == '(' && cnt > 0) {
                cnt--;
            } else {
                filtered.append(c);
            }
        }
        return filtered.reverse().toString();
    }
}