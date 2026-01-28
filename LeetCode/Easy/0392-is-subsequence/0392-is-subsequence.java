class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        Boolean [][] dp = new Boolean [n+1][m+1];
        return helper(s,t,n,m,dp , 0 , 0);
    }

    public static boolean helper(String s , String t , int n , int m , Boolean[][] dp , int i , int j){
        if(i == n) return true;
        if(j == m) return false;

        if(dp[i][j] != null){
            return dp[i][j];
        }

        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] =  helper(s , t , n , m , dp , i+1 , j+1);
        }
        else{
            dp[i][j] = helper(s,t,n,m,dp,i,j+1);
        }

        return dp[i][j];

    }
}