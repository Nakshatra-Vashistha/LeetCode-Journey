class Solution {
    static int n;
    static int[][] dp;
    public int minDifficulty(int[] jobDifficulty, int d) {

        n = jobDifficulty.length;
        if(n < d){
            return -1;
        }

        dp = new int[n+1][d+1];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }

        
        return solve(0 , d , jobDifficulty);
    }

    public static int solve(int i , int d , int[] jD ){
        if(d==1){
            int ans = 0;
            for(int j = i; j  < n ; j++){
                ans = Math.max(ans ,jD[j]);
            }
            return ans;
        }

        if(dp[i][d] != -1){
            return dp[i][d];
        }

        int maxValue = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE;

        for(int j = i ; j <= n - d ; j++){
            maxValue = Math.max(maxValue , jD[j]);
            result = Math.min(result , maxValue + solve(j+1 , d-1 , jD));
        }

        return dp[i][d] =  result;
    }
}