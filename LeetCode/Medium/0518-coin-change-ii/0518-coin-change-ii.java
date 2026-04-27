class Solution {
    static int N;
    static int count;
    public int change(int amount, int[] coins) {
        N = coins.length;
        count = 0;
        int[][] dp = new int[N][amount+1];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }

        return helper(0 , coins , amount , dp);
        
    }

    public static int helper(int idx , int[] coins , int target , int[][] dp){
        if(idx == N) return 0 ;

        if(target == 0){
            return 1;
        }

        if(dp[idx][target] != -1){
            return dp[idx][target];
        }

        int nottake = helper(idx+1 , coins , target , dp);

        int take = 0;
        if(coins[idx] <= target){
            take = helper(idx , coins , target-coins[idx] , dp);
        }

        return dp[idx][target] = nottake + take;
    }
}