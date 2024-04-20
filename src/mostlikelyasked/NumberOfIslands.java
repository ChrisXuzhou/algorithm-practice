package mostlikelyasked;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        int ret =
                new NumberOfIslands()
                        .numIslands(grid);

        System.out.println(ret);
    }

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dirt(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dirt(char[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length) return;
        if (j < 0 || j >= grid[0].length) return;

        if (grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '9';

        dirt(grid, i + 1, j);
        dirt(grid, i - 1, j);
        dirt(grid, i, j + 1);
        dirt(grid, i, j - 1);
    }

}
