class Solution {
    public int numSquares(int n) {
        Integer[] dp = new Integer[n+1];
        return helper(n , dp);
    }

    private static int helper(int rem , Integer[] dp){
        if(rem == 0){
            return 0;
        }

        if(dp[rem] != null){
            return dp[rem];
        }

        int take = (int)1e9;

        for(int i = 1 ; i*i <= rem ; i++){
            int sq = i*i;

            take = Math.min(take , 1 + helper(rem - sq , dp));
        }

        return dp[rem] =  take;
    }
}