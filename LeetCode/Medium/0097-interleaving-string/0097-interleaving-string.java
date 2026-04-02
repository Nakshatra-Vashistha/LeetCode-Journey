class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (n + m != s3.length()) return false;

        // Using Integer to represent 3 states: -1 (unvisited), 1 (true), 0 (false)
        int[][] memo = new int[n + 1][m + 1];
        for (int[] row : memo) Arrays.fill(row, -1);

        return solve(s1, s2, s3, 0, 0, memo);
    }

    private boolean solve(String s1, String s2, String s3, int i, int j, int[][] memo) {
        if (i == s1.length() && j == s2.length()) return true;

        if (memo[i][j] != -1) return memo[i][j] == 1;

        boolean ans = false;
        int k = i + j; 

        
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            ans = solve(s1, s2, s3, i + 1, j, memo);
        }

        if (!ans && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            ans = solve(s1, s2, s3, i, j + 1, memo);
        }

        memo[i][j] = ans ? 1 : 0;
        return ans;
    }
}