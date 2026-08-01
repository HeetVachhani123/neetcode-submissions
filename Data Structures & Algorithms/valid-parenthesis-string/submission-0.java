class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--; // treat '*' as ')'
                maxOpen++; // treat '*' as '('
            }

            // If maxOpen is negative, we have more ')' than available open brackets
            if (maxOpen < 0) {
                return false;
            }

            // minOpen cannot be negative since we can't have negative unmatched '('
            minOpen = Math.max(0, minOpen);
        }

        // Valid if it's possible to have 0 open brackets left at the end
        return minOpen == 0;
    }
}