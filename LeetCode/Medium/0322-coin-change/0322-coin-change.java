class Solution {
    static int N;
    public int coinChange(int[] coins, int amount) {
        N = coins.length;
        int[][] dp = new int[N][amount+1];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        int ans = helper( 0 , coins , amount , dp);
        return ans >= (int)1e9 ? -1 : ans;
        
    }

    public int helper(int idx , int[] coins , int target , int[][] dp){
        if(target == 0){
            return 0;
        }
        if(idx == N){
            return (int)1e9;
        }

        if(dp[idx][target] != -1){
            return dp[idx][target];
        }

        int nottake = helper(idx+1,coins,target,dp);

        int take = (int)1e9;
        if(coins[idx] <= target){
            take = 1 + helper(idx , coins , target - coins[idx], dp);
        }

        return dp[idx][target] =  Math.min(take , nottake);

    }
}