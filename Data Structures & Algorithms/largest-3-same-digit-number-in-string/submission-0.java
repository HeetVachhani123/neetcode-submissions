public class Solution {
    public String largestGoodInteger(String num) {
        char maxChar = ' ';
        
        // Loop through the string to find three consecutive identical characters
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                // Keep track of the largest character found
                if (maxChar == ' ' || num.charAt(i) > maxChar) {
                    maxChar = num.charAt(i);
                }
            }
        }
        
        // If no triplet was found, return an empty string
        if (maxChar == ' ') {
            return "";
        }
        
        // Construct and return the 3-digit string
        return new String(new char[]{maxChar, maxChar, maxChar});
    }
}