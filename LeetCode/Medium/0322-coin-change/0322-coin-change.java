class Solution {
    static int maxV;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer[][] dp = new Integer[n+1][amount+1];
        maxV = (int)1e9;
        int ans = helper(0 , n,coins,dp , amount);
        return ans == maxV ? -1 : ans;
    }

    private static int helper(int idx , int size , int[] coins , Integer[][] dp , int target){
        if(idx == size){
            return maxV;
        }
        if(target == 0){
            return 0;
        }

        if(dp[idx][target] != null){
            return dp[idx][target];
        }

        int nottake = helper(idx+1 , size , coins , dp , target);

        int take = maxV;
        if(coins[idx] <= target){
            take = 1 + helper(idx , size , coins , dp , target - coins[idx]);
        }

        return dp[idx][target] = Math.min(take , nottake);
    }
}