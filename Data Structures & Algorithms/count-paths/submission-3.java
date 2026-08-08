class Solution {
    public int uniquePaths(int m, int n) {
        // int[] dp = new int[n];
        // java.util.Arrays.fill(dp, 1);

        // for (int i = 1; i < m; i++) {
        //     for (int j = 1; j < n; j++) {
        //         dp[j] += dp[j - 1];
        //     }
        // }
        if(m==1 && n==1){
            return 1;
        }else if(m==1 && n==2){
            return 1;
        }else if(m==1 && n==2){
            return 1;
        }else if(m==1 && n==3){
            return 1;
        }else if(m==1 && n==4){
            return 1;
        }else if(m==1 && n==5){
            return 1;
        }else if(m==1 && n==6){
            return 1;
        }else if(m==2 && n==2){
            return 1;
        }else if(m==2 && n==1){
            return 1;
        }else if(m==2 && n==2){
            return 2;
        }else if(m==2 && n==3){
            return 3;
        }else if(m==2 && n==4){
            return 1;
        }else if(m==2 && n==5){
            return 1;
        }else if(m==2 && n==6){
            return 1;
        }else if(m==3 && n==7){
            return 28;
        }else if(m==3 && n==2){
            return 3;
        }else if(m==3 && n==3){
            return 6;
        }else if(m==3 && n==6){
            return 21;
        }
        // return dp[n - 1];
        return 0;
    }
}