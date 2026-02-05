class Solution {
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    static int rowl,coll;
    public int numEnclaves(int[][] grid) {
        rowl = grid.length;
        coll = grid[0].length;

        for (int j = 0; j < rowl; j++) {
            if (grid[0][j] == 1) dfs(0, j, grid);
            if (grid[rowl - 1][j] == 1) dfs(rowl - 1, j, grid);
        }

        
        for (int i = 0; i < coll; i++) {
            if (grid[i][0] == 1) dfs(i, 0, grid);
            if (grid[i][coll - 1] == 1) dfs(i, coll - 1, grid);
        }
        int res = 0;

        for(int i = 0 ; i < rowl ; i++){
            for(int j = 0 ; j < coll ; j++){
                if(grid[i][j] == 1){
                    res++;
                }
            }
        }

        return res;

        
    }

    public static void dfs(int r , int c , int[][] grid){
        if(r < 0 || c < 0 || r >= rowl || c >= coll || grid[r][c] == 0){
            return;
        }
        grid[r][c] = 0;
        for(int i = 0 ; i < 4 ; i++){
            dfs(r+dr[i] , c+dc[i],grid);
        }
    }
}