class Solution {
    static int N;
    static int[] dr = {-1,1,0,0,-1,-1,1,1};
    static int[] dc = {0,0,-1,1,-1,1,-1,1};
    public int shortestPathBinaryMatrix(int[][] grid){
        N = grid.length;

        if(grid[0][0] == 1 || grid[N-1][N-1] == 1){
            return -1;
        }
        if(N == 1) return 1;

        
        

        Queue< int[] > q = new LinkedList<>();

        q.offer(new int[]{0,0});
        int path = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i < size ; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int j = 0 ; j < 8 ; j++){
                int nR = r + dr[j];
                int nC = c + dc[j];

                    if(nR == N-1 && nC == N-1){
                        return path + 1;
                    }

                    if(nR >= 0 && nC >= 0 && nR < N && nC < N && grid[nR][nC] == 0){
                        q.offer(new int[]{nR,nC});
                        grid[nR][nC] = 1;
                    }
                }
            }
            path++;
        }

        return -1;


        
    }
}