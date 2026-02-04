class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Queue<Integer> pq = new LinkedList<>();
        boolean[] visited = new boolean[n];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0 ; i<n ;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] list : edges ){
            int u = list[0];
            int v = list[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

    dfs(source , visited , adj );

      for(int i = 0 ;i<visited.length; i++){
            if(i == destination && visited[i] == true){
                return true;
            }
      }
        return false;
    }

    public void dfs(int src , boolean[] vis , List<List<Integer>> adj){
        vis[src] = true;
        for(int adjNode : adj.get(src)){
            if(vis[adjNode] == false){
                dfs(adjNode , vis , adj);
            }
        }
    }
}