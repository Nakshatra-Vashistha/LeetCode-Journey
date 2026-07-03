class Solution {
    static int size;
    static int MAX = (int)1e9;
    public int coinChange(int[] coins, int amount) {
        size = coins.length;
        Integer[][] dp = new Integer[size][amount+1];
        int ans = coinChange( 0 , coins , amount , dp);
        return ans == MAX ? -1 : ans;
    }

    private int coinChange(int idx , int[] coins , int amount , Integer[][] dp){
        if(amount == 0){
            return 0;
        }
        if(idx == size){
            return MAX;
        }

        if(dp[idx][amount] != null){
            return dp[idx][amount];
        }

        int nottake = coinChange(idx+1 , coins , amount , dp);

        int take = MAX;
        if(coins[idx] <= amount){
            take = 1 +  coinChange(idx , coins , amount - coins[idx] , dp);
        }

        return dp[idx][amount] =  Math.min(take , nottake);
    }
}