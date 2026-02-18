class Solution {
    static int[] parent;
    static int[] rank;
    static int component;

    public int removeStones(int[][] stones) {
        int n = stones.length;
        int m = stones[0].length;
        component = n;
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            parent[i] = i;
        }

        for(int i = 0 ; i<n ; i++){
            for(int j = i+1 ; j < n ; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    if(unionrank(i,j)){
                        component--;
                    }
                }
            }
        }

        return n-component;




        
    }

    public static int find(int x){
            if(x==parent[x]) return x;
            return parent[x] = find(parent[x]);
    }

    public static boolean unionrank(int x , int y){
        int p_x = find(x);
        int p_y = find(y);
        if(p_x == p_y){
            return false;
        }
        if(rank[p_x] > rank[p_y]){
            parent[p_y] = p_x;
        }
        else if(rank[p_x] > rank[p_y]){
            parent[p_x] = p_y;
        }
        else{
            parent[p_x] = p_y;
            rank[p_y]++;
        }
        return true;

    }
}