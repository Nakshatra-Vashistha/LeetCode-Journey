class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int rowl , coll;
    public int closedIsland(int[][] grid) {
        rowl = grid.length;
        coll = grid[0].length;

        for(int i = 0 ; i < rowl ; i++){
            if(grid[i][0] == 0) dfs(i , 0 , grid);
            if(grid[i][coll-1] == 0) dfs(i , coll-1 , grid);
        }
        for(int j = 0 ; j < coll ; j++){
            if(grid[0][j] == 0) dfs(0 , j , grid);
            if(grid[rowl-1][j] == 0) dfs(rowl-1 , j , grid);
        }
        int islands = 0;
        for(int i = 0 ; i < rowl ; i++){
            for(int j = 0 ; j < coll ; j++){
                if(grid[i][j] == 0){
                    dfs(i , j , grid);
                    islands++;
                }
            }
        }
        return islands;

        
    }
    public void dfs(int r , int c , int[][] grid){
        if(r < 0 || c < 0 || r >= rowl || c >= coll || grid[r][c] == 1){
            return ;
        }
        grid[r][c] = 1;
        for(int i = 0 ; i < 4 ; i++){
            dfs(r+dr[i] , c+dc[i] , grid);
        }
    }
}