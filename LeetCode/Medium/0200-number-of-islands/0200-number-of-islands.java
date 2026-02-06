class Solution {
    static int rLen;
    static int cLen;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static char[] direction = {'U','D','L','R'};

    static class pair{
        int row;
        int col;
        public pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }
    public int numIslands(char[][] grid) {
        rLen = grid.length;
        cLen = grid[0].length;

        boolean[][] vis = new boolean[rLen][cLen];
        int components = 0;
        for(int i = 0 ; i < rLen ; i++){
            for(int j = 0 ; j < cLen ; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    bfs(i,j,vis,grid);
                    components++;
                }
            }
        }
        return components;
        
    }

    public void bfs(int r , int c , boolean[][] vis , char[][] grid){
        Queue<pair> q = new LinkedList<>();
        vis[r][c] = true;

        q.offer(new pair(r,c));

        while(!q.isEmpty()){
            pair curr = q.poll();
            int R = curr.row;
            int C = curr.col;

            for(int i = 0 ; i < 4 ; i++){
                int nRow = R+dr[i];
                int nCol = C + dc[i];

                if(nRow >= 0 && nCol >= 0 && nRow < rLen && nCol < cLen && !vis[nRow][nCol] && grid[nRow][nCol] == '1'){
                    vis[nRow][nCol] = true;
                    q.offer(new pair(nRow,nCol));
                }
            }
        }
    }
}