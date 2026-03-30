class Solution {
    static int n;
    static int m;
    private static int mod = 1_000_000_007;
    static Integer[][][] dp ;
    public int numberOfPaths(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;

        dp = new Integer[n][m][k];

        return helper(0,0,0,grid,k);



        
        
    }

    public static int helper(int i , int j , int sum , int[][] grid , int k){
        if(i >= n || j >= m){
            return 0 ;
        }

        int currsum = (sum+grid[i][j]) % k;
        if(i == n-1 && j == m-1){
            return (currsum == 0 )? 1 : 0 ;
        }

        if(dp[i][j][currsum] != null){
            return dp[i][j][currsum];
        }

        long left = helper(i+1 , j , currsum , grid , k);
        long down = helper(i , j+1 , currsum , grid,  k);

        return dp[i][j][currsum] = (int)((left+down) % mod) ;
        
    }
}