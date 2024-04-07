package mostlikelyasked;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        System.out.println(
                new WordSearch()
                        .exist(board, "AAB")
        );
    }

    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0 || board[0].length == 0 || word.length() == 0) return false;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (trace(board, word, 0, i, j, m, n))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean trace(char[][] board, String word, int k, int i, int j, int m, int n) {

        if (k == word.length()) {
            return true;
        }

        if (i < 0 || i >= m || j < 0 || j >= n || word.charAt(k) != board[i][j]) {
            return false;
        }

        char tmp = board[i][j];
        board[i][j] = '0'; // mark the traced position

        boolean found =
                trace(board, word, k + 1, i + 1, j, m, n) ||
                        trace(board, word, k + 1, i, j + 1, m, n) ||
                        trace(board, word, k + 1, i - 1, j, m, n) ||
                        trace(board, word, k + 1, i, j - 1, m, n);

        board[i][j] = tmp;

        return found;
    }
}
