class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, temp , ans , visited);

        return ans;
        
    }

    public static void helper(int[] nums , ArrayList<Integer> temp, List<List<Integer>> ans , boolean[] visited ){
        int n = nums.length;

        if(temp.size() == n){
            ArrayList<Integer> res = new ArrayList<>(temp);
            ans.add(res);
            return ;
        }

        for(int i = 0 ; i < n ; i++){
            if(visited[i] == true) continue ;

            visited[i] = true;
            temp.add(nums[i]);
            helper(nums , temp , ans , visited);
            visited[i] = false;
            temp.remove(temp.size()-1);

        }

    }
}