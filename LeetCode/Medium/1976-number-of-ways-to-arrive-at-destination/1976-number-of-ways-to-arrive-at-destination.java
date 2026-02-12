class Solution {
    static class pair{
        int node;
        long dis;
        public pair(int  node , long dis){
            this.node = node;
            this.dis = dis;
        }
    }
    static final int mod = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] row : roads){
            int u = row[0];
            int v = row[1];
            long w = row[2];
            adj.get(u).add(new pair(v,w));
            adj.get(v).add(new pair(u,w));
        }

        

        long[] distance = new long[n+1];
        Arrays.fill(distance , Long.MAX_VALUE);
        distance[0] = 0;
        long[] ways = new long[n+1];
        
        ways[0] = 1;
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.dis , b.dis));
        pq.offer(new pair(0,0));

        while(!pq.isEmpty()){
            pair curr = pq.poll();
            int u = curr.node;
            long dist = curr.dis;

            if(dist > distance[u]) continue;

            for(pair adjnode : adj.get(u)){
                int v = adjnode.node;
                long cost = adjnode.dis;
                if(distance[v] > distance[u] + cost){
                    distance[v] = distance[u]+cost;
                    ways[v] = ways[u];
                    pq.offer(new pair(v , distance[v]));
                    
                }
                else if(distance[v] == distance[u]  + cost){
                    ways[v] = (ways[u] + ways[v]) % mod;
                }
            }

        }

        return (int)ways[n-1];


        
    }
}

// class Solution {
//     static class Pair{
//         int node;
//         long dis;
//         public Pair(int node,long dis){
//             this.node=node;
//             this.dis=dis;
//         }
//     }
//     static final long  mod=1_000_000_007;
//     public int countPaths(int n, int[][] roads) {
//         ArrayList<ArrayList<Pair>> adj=new ArrayList<>();

//         for(int i=0;i<=n;i++){
//             adj.add(new ArrayList<>());
//         }

//         long[] distance=new long[n];
//         Arrays.fill(distance,Long.MAX_VALUE);
//         distance[0]=0;

//         for(int[] r:roads){
//             int u=r[0];
//             int v=r[1];
//             int w=r[2];
    
//             adj.get(u).add(new Pair(v,w));
//             adj.get(v).add(new Pair(u,w));

//         }
//         PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.dis,b.dis));
//         pq.offer(new Pair(0,0));
//         long[] ways=new long[n];
//         ways[0]=1;

//         while(!pq.isEmpty()){
//             Pair curr=pq.poll();
//             int u=curr.node;
//             long d=curr.dis;

//             if( d > distance[u] ) continue;

//             for(Pair p:adj.get(u)){
//                 int v=p.node;
//                 long cost_u_v=p.dis;

//                 if(distance[v] > distance[u] + cost_u_v ) {

//                     distance[v] = distance[u] + cost_u_v;
//                     ways[v]=ways[u];
//                     pq.offer(new Pair(v,distance[v]) );

//                 }
//                  else  if(distance[v] == distance[u] + cost_u_v ){
//                       ways[v]=(ways[v]+ways[u])%mod;
//                   }
//             }
//         }

//         return (int)ways[n-1];
     
//     }
// }