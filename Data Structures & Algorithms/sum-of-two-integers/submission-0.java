class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            // Compute carry bits
            int carry = (a & b) << 1;
            
            // Sum without carry
            a = a ^ b;
            
            // Pass carry to b for the next iteration
            b = carry;
        }
        return a;
    }
}