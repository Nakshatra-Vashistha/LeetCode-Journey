class Solution {
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    static int rowl;
    static int coll;
    public int islandPerimeter(int[][] grid) {
        rowl = grid.length;
        coll = grid[0].length;
        boolean[][] visited = new boolean[rowl][coll];

        for(int i = 0 ; i < rowl ; i++){
            for(int j = 0 ; j < coll ; j++){
                if(grid[i][j] ==1){
                    return dfs(i , j , grid , visited);
                    
                    
                }
            }
            
        }
        return 0;
        
    }

    public static int dfs(int r , int c , int[][] grid , boolean[][] visited){
        if(r < 0 || c < 0 || r >= rowl || c >= coll || grid[r][c] == 0){
            return 1;
        }
        if(visited[r][c] == true){
            return 0 ;
        }
        visited[r][c] = true;
        int peri = 0;

        for(int i = 0 ; i < 4 ; i++){
            peri = peri + dfs(r+dr[i] , c+dc[i] , grid , visited);
        }

        return peri;
    }
}