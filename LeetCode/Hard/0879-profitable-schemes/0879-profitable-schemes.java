class Solution {
    static int MOD = 1_000_000_007;
    static Integer[][][] memo;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        memo = new Integer[group.length][n + 1][minProfit + 1];
        
        return solve(0, 0, 0, n, minProfit, group, profit);
    }

    private int solve(int i, int members, int currentProfit, int n, int minProfit, int[] group, int[] profit) {
        if (i == group.length) {
            return currentProfit >= minProfit ? 1 : 0;
        }

      
        if (memo[i][members][currentProfit] != null) {
            return memo[i][members][currentProfit];
        }

        
        int totalWays = solve(i + 1, members, currentProfit, n, minProfit, group, profit);


        if (members + group[i] <= n) {
            
            int newProfit = Math.min(minProfit, currentProfit + profit[i]);
            totalWays += solve(i + 1, members + group[i], newProfit, n, minProfit, group, profit);
        }

        return memo[i][members][currentProfit] = (totalWays % MOD);
    }
}