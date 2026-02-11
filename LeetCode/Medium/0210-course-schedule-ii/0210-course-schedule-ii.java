class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i = 0 ; i < numCourses; i++ ){
            adj.add(new ArrayList<>());
        }
        for(int[] row : prerequisites){
            int u = row[0];
            int v = row[1];
            adj.get(v).add(u);
            indegree[u]++;

        }
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList();

        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int top = q.poll();
            ans.add(top);

            for(int adjnode : adj.get(top)){
                indegree[adjnode]--;
                if(indegree[adjnode] == 0){
                    q.offer(adjnode);
                }
            }
        }
        if(ans.size() != numCourses){
            return new int[0];
        }
        int[] res = new int[numCourses];
        for(int i = 0 ; i < numCourses ;i++){
            res[i] = ans.get(i);
        }

        return res;
        
    }
}