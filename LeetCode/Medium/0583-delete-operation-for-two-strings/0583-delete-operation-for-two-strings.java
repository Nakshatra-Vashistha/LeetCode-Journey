class Solution {
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();

        if(word1.equals(word2)) return 0;


        int[][] dp = new int[n+1][m+1];

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        int count = 0;

        int i = n;
        int j = m;
        while(i>0 && j > 0){
            if(word1.charAt(i-1) == word2.charAt(j-1) ){
                count++;
                i--;
                j--;

            }
            else{
                if(dp[i-1][j] > dp[i][j-1]){
                    i--;
                }
                else{
                    j--;
                }
            }
        }

        return (n-count) + (m-count);
        
    }
}