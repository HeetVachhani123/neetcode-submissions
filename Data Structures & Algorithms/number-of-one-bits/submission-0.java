class Solution {
    public int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        int zeros = 0;
        int ones = 0;
        int x = str.length();
        for(int i=0;i<x;i++){
            if(str.charAt(i)=='0'){
                zeros++;
            }else if(str.charAt(i)=='1'){
                ones++;
            }
        }
        return ones;
    }
}
