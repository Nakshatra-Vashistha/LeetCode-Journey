class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        Arrays.fill(dp , -1);
        return solve( 0 , questions , dp);
        
    }

    public static long solve(int i , int[][] ques , long[] dp){
        if(i >= ques.length){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        //take
        long take = ques[i][0]  +  solve(i + ques[i][1] + 1 , ques , dp);

        //skip
        long skip = solve(i+1, ques , dp );

        return dp[i] = Math.max(take , skip);
    }
}