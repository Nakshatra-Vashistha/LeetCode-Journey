class Solution {
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    static int rowl;
    static int coll;
    public int numIslands(char[][] grid) {
        rowl = grid.length;
        coll = grid[0].length;

        int islands = 0;

        for(int i = 0 ; i < rowl ; i++){
            for(int j = 0 ; j < coll ; j++){
                if(grid[i][j] =='1'){
                    dfs(i , j , grid);
                    islands++;
                }
            }
        }
        return islands;
        
        
    }

    static void dfs(int r , int c , char[][] grid){
        if(r < 0 || c < 0 || r >= rowl || c >= coll || grid[r][c] == '0'){
            return ;
        }

        grid[r][c] = '0';

        for(int i = 0 ; i < 4 ; i++){
            dfs(r+dr[i] , c+dc[i] , grid);
        }
    }
}