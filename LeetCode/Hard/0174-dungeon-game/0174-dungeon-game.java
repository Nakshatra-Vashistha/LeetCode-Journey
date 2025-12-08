class Solution {
    public int calculateMinimumHP(int[][] dungeon) {

        int row = dungeon.length;
        int col = dungeon[0].length;

        int dp[][] = new int[row+1][col+1];

        for(int[] rowE : dp){
            Arrays.fill(rowE , Integer.MAX_VALUE);
        }

        dp[row-1][col] = 1;
        dp[row][col-1] = 1;

        for(int i = row-1 ; i >= 0 ; i-- ){
            for(int j = col-1 ; j >=0 ; j--){
                int minVal = Math.min(dp[i+1][j] , dp[i][j+1]);

                dp[i][j] = Math.max(1 , minVal - dungeon[i][j]);
            }
        }

        return dp[0][0];
        
    }
}