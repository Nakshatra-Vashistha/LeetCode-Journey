class Solution {
    List<Integer>[] tree;
    static int[] distance;
    static int[] subtree;
    int[] ans;
    int N;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N = n;
        tree = new ArrayList[n];
        distance = new int[n+1];
        subtree = new int[n+1];
        ans = new int[n];

        for(int i = 0 ; i < n ; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n-1 ; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(0,-1);
        ans[0] = distance[0];

        reRoot(0,-1);
        return ans;

        //rerooting
    }

    public void dfs(int node , int parent){
        subtree[node] = 1;
        for(int child :tree[node]){
            if(child == parent) continue;
            dfs(child , node);
            subtree[node] += subtree[child];
            distance[node] += distance[child]+subtree[child];
        }
    }

    public void reRoot(int node , int parent){
        for(int child : tree[node]){
            if(child == parent) continue;
            ans[child] = ans[node] + N - 2 * subtree[child];
            reRoot(child , node);
        }
    }
}