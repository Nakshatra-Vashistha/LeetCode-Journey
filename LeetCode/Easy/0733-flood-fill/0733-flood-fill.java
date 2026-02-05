class Solution {
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    static int rowl;
    static int coll;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        rowl = image.length;
        coll = image[0].length;
        int og = image[sr][sc];

        // for(int i = sr ; i < rowl ; i++){
        //     for(int j = sc ; j < coll ; j++){
        //         dfs(i,j,image,color , og);
        //     }
        // }
        dfs(sr,sc,image,color , og);
        return image;
        
    }

    static void dfs(int sr , int sc , int[][] image , int color , int og){
        if(sr < 0 || sc < 0 || sr >= rowl || sc >= coll || image[sr][sc] != og){
            return ;
        }
        if(image[sr][sc] == color){
            return ;
        }
        image[sr][sc] = color;

        for(int i = 0 ; i < 4 ; i++){
            dfs(sr + dr[i] , sc + dc[i] , image , color , og);
        }
    }
}