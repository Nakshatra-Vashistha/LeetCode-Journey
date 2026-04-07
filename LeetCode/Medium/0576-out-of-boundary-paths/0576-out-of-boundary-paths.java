class Solution {
    static int MOD = 1_000_000_007;
    static int moves;
    static int M, N;
    static Integer[][][] dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        moves = maxMove;
        M = m;
        N = n;
        dp = new Integer[M + 1][N + 1][maxMove + 1];
        return solve(startRow, startColumn, 0);
    }
    public int solve(int row, int col, int currMove){
        if(row < 0 || row >= M || col < 0 || col >= N){
            return 1;
        }

        if(currMove >= moves){
            return 0;
        }

        if(dp[row][col][currMove] != null){
            return dp[row][col][currMove];
        }

        int ans = 0;

        // left
        int left = solve(row , col - 1, currMove + 1);
        ans = (ans + left) % MOD;

        // right
        int right = solve(row , col + 1, currMove + 1);
        ans = (ans + right) % MOD;

        // up
        int up = solve(row - 1, col, currMove + 1);
        ans = (ans + up) % MOD;

        // down
        int down = solve(row + 1, col, currMove + 1);
        ans = (ans + down) % MOD;

        return dp[row][col][currMove]  = ans % MOD;
    }
}