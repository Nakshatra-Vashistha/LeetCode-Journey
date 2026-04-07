class Solution {
    static int M;
    static int N;
    static int Target;
    static int[] house;
    static Integer[][][] dp;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        M = m;
        N = n;
        Target = target;
        house = houses;
        dp = new Integer[m+1][n+1][target+1];

        
        int result = helper(0, 0, 0, cost);
        
        
        return result >= 1e9 ? -1 : result;
    }

    public static int helper(int idx, int prevColor, int neigh, int[][] cost) {
        // Base cases
        if (neigh > Target) {
            return (int) 1e9;
        }
        if (idx == M) {
            return (Target == neigh) ? 0 : (int) 1e9;
        }

        if(dp[idx][prevColor][neigh] != null){
            return dp[idx][prevColor][neigh];
        }

        int ans = (int) 1e9;

        if (house[idx] != 0) {
            
            int currentColor = house[idx];
            ans = helper(idx + 1, currentColor, (currentColor != prevColor) ? neigh + 1 : neigh, cost);
        } 
        else {
            
            for (int c = 1; c <= N; c++) {
            
                int res = cost[idx][c - 1] + helper(idx + 1, c, (c != prevColor) ? neigh + 1 : neigh, cost);
                ans = Math.min(ans, res);
            }
        }

        return dp[idx][prevColor][neigh] =  ans;
    }
}