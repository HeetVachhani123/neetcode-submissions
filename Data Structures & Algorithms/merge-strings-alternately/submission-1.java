class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        StringBuilder ans = new StringBuilder();

        for(int i=0;i<Math.min(m,n);i++){
            ans.append(word1.charAt(i));
            ans.append(word2.charAt(i));
        }
        if(m>n){
            ans.append(word2.substring(n));
        }else if(n>m){
            ans.append(word1.substring(m));
        }
        return ans.toString();
    }
}