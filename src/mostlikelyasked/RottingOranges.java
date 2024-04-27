package mostlikelyasked;

import java.util.LinkedList;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int minutes = new RottingOranges()
                .orangesRotting(grid);
        System.out.println(
                minutes
        );
    }

    public int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    int minutes = track(grid, i, j);
                    max = Math.max(max, minutes);
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return max;
    }

    int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    private int track(int[][] grid, int i, int j) {

        if (grid[i][j] != 2) {
            // expect (i, j) is a rotten orange.
            return 0;
        }

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int minutes = 0;

        while (true) {

            LinkedList<int[]> newQueue = new LinkedList<>();

            while (!queue.isEmpty()) {
                int[] p = queue.pop();

                grid[p[0]][p[1]] = 0; // make the processed space an empty space.

                for (int[] dir : directions) {
                    int ni = p[0] + dir[0];
                    int nj = p[1] + dir[1];

                    if (
                            ni >= 0 && ni < grid.length
                                    && nj >= 0 && nj < grid[0].length
                                    && grid[ni][nj] == 1 // expect a fresh orange
                    ) {
                        newQueue.add(new int[]{ni, nj});
                    }
                }
            }

            if (newQueue.isEmpty()) {
                break;
            } else {
                minutes++;
                queue = newQueue;
            }

        }

        return minutes;
    }

}
