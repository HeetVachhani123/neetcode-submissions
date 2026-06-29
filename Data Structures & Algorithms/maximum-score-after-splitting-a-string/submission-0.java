public class Solution {
    public int maxScore(String s) {
        int totalOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }
        
        int maxScore = 0;
        int zerosLeft = 0;
        int onesLeft = 0;
        
        // Loop up to length - 1 to ensure the right substring is never empty
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zerosLeft++;
            } else {
                onesLeft++;
            }
            
            int currentScore = zerosLeft + (totalOnes - onesLeft);
            maxScore = Math.max(maxScore, currentScore);
        }
        
        return maxScore;
    }
}