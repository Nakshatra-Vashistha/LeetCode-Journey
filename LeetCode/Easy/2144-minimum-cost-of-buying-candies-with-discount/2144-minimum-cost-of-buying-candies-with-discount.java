class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        int sum = 0;
        

        Arrays.sort(cost);

        int skip = 0;
        for(int i = n-1 ; i >= 0; i--){
            if(skip == 2){
                skip = 0;
            }
            else{
                sum += cost[i];
                skip++;
            }
        }

        return sum;
    }
}