public class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }
        
        long sum = 0;
        for (int stick : matchsticks) {
            sum += stick;
        }
        
        if (sum % 4 != 0) {
            return false;
        }
        
        int target = (int) (sum / 4);
        
        java.util.Arrays.sort(matchsticks);
        reverse(matchsticks);
        
        if (matchsticks[0] > target) {
            return false;
        }
        
        int[] sides = new int[4];
        return backtrack(matchsticks, sides, 0, target);
    }
    
    private boolean backtrack(int[] matchsticks, int[] sides, int index, int target) {
        if (index == matchsticks.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }
        
        int currentStick = matchsticks[index];
        
        for (int i = 0; i < 4; i++) {
            if (sides[i] + currentStick <= target) {
                sides[i] += currentStick;
                if (backtrack(matchsticks, sides, index + 1, target)) {
                    return true;
                }
                sides[i] -= currentStick;
            }
            
            if (sides[i] == 0) {
                break;
            }
        }
        
        return false;
    }
    
    private void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}