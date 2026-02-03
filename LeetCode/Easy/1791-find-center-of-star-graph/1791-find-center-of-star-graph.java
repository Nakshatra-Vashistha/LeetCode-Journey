class Solution {
    public int findCenter(int[][] edges) {
        int V = edges.length;

        int[] degree = new int[V+2];

        for(int[] edge : edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        for(int i = 1 ; i <= V+1 ; i++){
            if(degree[i] == V) return i;
        }

        return -1;
        
    }
}