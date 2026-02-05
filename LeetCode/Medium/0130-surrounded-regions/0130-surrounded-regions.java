class Solution {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int rowl, coll;

    public void solve(char[][] board) {

        if (board == null || board.length == 0) return;

        rowl = board.length;
        coll = board[0].length;

        
        for (int j = 0; j < coll; j++) {
            if (board[0][j] == 'O') dfs(0, j, board);
            if (board[rowl - 1][j] == 'O') dfs(rowl - 1, j, board);
        }

        
        for (int i = 0; i < rowl; i++) {
            if (board[i][0] == 'O') dfs(i, 0, board);
            if (board[i][coll - 1] == 'O') dfs(i, coll - 1, board);
        }

        
        for (int i = 0; i < rowl; i++) {
            for (int j = 0; j < coll; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private static void dfs(int r, int c, char[][] board) {
        if (r < 0 || c < 0 || r >= rowl || c >= coll || board[r][c] != 'O') {
            return;
        }

        board[r][c] = '#'; 

        for (int i = 0; i < 4; i++) {
            dfs(r + dr[i], c + dc[i], board);
        }
    }
}
