class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];

        Queue<Integer> pq = new LinkedList<>();

        vis[0] = true;
        pq.offer(0);

        while(!pq.isEmpty()){
            int node = pq.poll();

            for(int adjNode : rooms.get(node)){
                if(vis[adjNode] == false){
                    vis[adjNode] = true;
                    pq.offer(adjNode);
                }
            }
        }

        for(int i = 0 ; i < vis.length ; i++){
            if(vis[i] == false) return false;
        }
        return true;
    }
}