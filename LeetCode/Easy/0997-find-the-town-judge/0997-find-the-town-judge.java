class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 1) return n;


        int[] in = new int[n+1];
        // int[] out = new int[n+1];

        for(int[] row : trust){
            in[row[0]]++;
            in[row[1]]--;
        }
        for(int i = 1 ; i <= n ; i++){
            if(in[i] == -(n-1)){
                return i;
            }
        }
        return -1;
        
    }
}