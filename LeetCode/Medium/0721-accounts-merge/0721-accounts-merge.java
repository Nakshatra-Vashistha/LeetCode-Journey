class Solution {
    static int[] parent;
    static int[] size;
    static int component;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String , Integer> emailtoid = new HashMap<>();
        //email ko uske account name ke sath associate karna hai
        HashMap<String , String> emailtoname = new HashMap<>();

        int id = 0;
        for(List<String> acc : accounts){
            String name = acc.get(0);
            for(int i = 1; i<acc.size(); i++){
                String email = acc.get(i);
                if(!emailtoid.containsKey(email)){
                    emailtoid.put(email,id++);
                }
                emailtoname.put(email , name);
            }
        }
        component = id;
        parent = new int[id];
        size = new int[id];
        for(int i = 0; i < id ; i++){
            parent[i] = i;
            size[i] = 1;
        }

        //same account ke mail ko marge karna hoga
        for(List<String> acc : accounts){
            if(acc.size() <= 2) continue;

            int firstaccountid = emailtoid.get(acc.get(1));
            for(int k = 2 ; k < acc.size() ; k++){
                union(firstaccountid , emailtoid.get(acc.get(k)));
            }

        }

        HashMap<Integer , List<String>> grouptoid = new HashMap<>();

        for(String email : emailtoid.keySet()){
            int emailid = emailtoid.get(email);
            int root = find(emailid);
            if(!grouptoid.containsKey(root)){
                grouptoid.put(root , new ArrayList<>());
            }
            grouptoid.get(root).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for(Integer node : grouptoid.keySet()){
            List<String> merge = grouptoid.get(node);
            Collections.sort(merge);
            List<String> answer = new ArrayList<>();
            answer.add(emailtoname.get(merge.get(0)));
            answer.addAll(merge);
            result.add(answer);
        }
        return result;


    }

    public static int find(int x){
            if(x==parent[x]) return x;
            return parent[x] = find(parent[x]);
    }

    public static boolean union(int x , int y){
        int p_x = find(x);
        int p_y = find(y);
        if(p_x == p_y){
            return false;
        }
        if(size[p_x] > size[p_y]){
            parent[p_y] = p_x;
        }
        else if(size[p_x] > size[p_y]){
            parent[p_x] = p_y;
        }
        else{
            parent[p_x] = p_y;
            size[p_y]++;
        }
        return true;

    }
}