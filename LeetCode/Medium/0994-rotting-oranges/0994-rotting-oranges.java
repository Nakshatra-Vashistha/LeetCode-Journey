class Solution {
    static int rLen;
    static int cLen;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    int maxTime = 0;

    static class pair{
        int r;
        int c;
        int time;
        public pair(int r , int c , int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        rLen = grid.length;
        cLen = grid[0].length;

        boolean[][] vis = new boolean[rLen][cLen];
        int fresh = 0;
        
        Queue<pair> q = new LinkedList<>();

        for(int i = 0 ; i < rLen ; i++){
            for(int j = 0 ; j < cLen ; j++){
                if(grid[i][j] == 2){
                    q.offer(new pair(i,j,0));
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;

        while(!q.isEmpty()){
            pair curr = q.poll();
            int row = curr.r;
            int col = curr.c;
            int T = curr.time;

            maxTime = Math.max(maxTime , T);

            for(int i = 0 ; i < 4 ; i++){
                int nRow = row + dr[i];
                int nCol = col + dc[i];

                if(nRow >= 0 && nCol >= 0 && nRow < rLen && nCol < cLen && grid[nRow][nCol] == 1){
                    grid[nRow][nCol] = 2;
                    fresh--;
                    q.offer(new pair(nRow , nCol , T+1));
                }
            }

        }

        return (fresh == 0) ? maxTime : -1;


        
    }
}