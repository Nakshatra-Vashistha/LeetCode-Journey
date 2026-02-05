class Solution {
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    static int rowl;
    static int coll;
    static int max;
    public int maxAreaOfIsland(int[][] grid) {

        rowl = grid.length;
        coll = grid[0].length;
        max = 0;
        

        for(int i = 0 ; i < rowl ; i++){
            for(int j = 0 ; j < coll ; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max , dfs(i , j , grid));
                }
            }
        }
        return max;

        
        

        
    }
    static int dfs(int r , int c , int[][] grid){
        if(r < 0 || c < 0 || r >= rowl || c >= coll || grid[r][c] == 0){
            return 0;
        }
        

        grid[r][c] = 0;
        int area = 1;

        for(int i = 0 ; i < 4 ; i++){
            area = area + dfs(r + dr[i],c + dc[i] , grid);
        }

        return area;
    }
}