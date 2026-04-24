class Solution {
    static int rlen;
    static int clen;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public int[][] updateMatrix(int[][] mat) {
        rlen = mat.length;
        clen = mat[0].length;

        int[][] dist = new int[rlen][clen];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < rlen ; i++){
            for(int j = 0 ; j < clen ; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
                else{
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }


        while(!q.isEmpty()){
            int[] curr = q.poll();
            int R = curr[0];
            int C = curr[1];

            for(int i = 0 ; i < 4 ; i++){
                int nR = R+dr[i];
                int nC = C+dc[i];

                if(nR >= 0 && nC >= 0 && nR < rlen && nC < clen && dist[nR][nC] > dist[R][C] + 1){
                    dist[nR][nC] = dist[R][C]+1;
                    q.offer(new int[]{nR,nC});
                }
            }
        }

        return dist;
        
    }
}