class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <= numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] row : prerequisites ){
            int u = row[0];
            int v = row[1];
            adj.get(u).add(v);
        }
        int[] indegree = new int[numCourses+1];
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < numCourses ; i++){
            for(int next : adj.get(i)){
                indegree[next]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int top = q.poll();
            ans.add(top);

            for(int adjnode : adj.get(top) ){
                indegree[adjnode]--;
                if(indegree[adjnode] == 0){
                    q.offer(adjnode);
                }
            }
        }

        return ans.size() == numCourses ? true : false;
        
    }
}