class Solution {
    public int climbStairs(int n) {
        Integer[] dp = new Integer[n+1];
        return helper(n , dp);
        
    }

    private int helper(int n , Integer[] dp){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }

        if(dp[n] != null){
            return dp[n];
        }

        int single = helper(n-1 , dp);
        int doubl = helper(n-2 , dp);

        return dp[n] =  single + doubl;
    }
}