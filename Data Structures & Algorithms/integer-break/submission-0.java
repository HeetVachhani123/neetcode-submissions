public class Solution {
    public int integerBreak(int n) {
        // Base cases where splitting reduces the product value
        if (n == 2) return 1; // 1 + 1 -> 1 * 1 = 1
        if (n == 3) return 2; // 2 + 1 -> 2 * 1 = 2
        
        int product = 1;
        
        // Greedily break down the number into 3s as long as the remainder is greater than 4
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        
        // Multiply the remaining value (which will be 2, 3, or 4)
        product *= n;
        
        return product;
    }
}