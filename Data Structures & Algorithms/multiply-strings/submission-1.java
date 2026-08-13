class Solution {
    public String multiply(String num1, String num2) {
        long x = Integer.valueOf(num1);
        long y = Integer.valueOf(num2);
        long z = x*y;
        String ans = String.valueOf(z);
        return ans;
    }
}
