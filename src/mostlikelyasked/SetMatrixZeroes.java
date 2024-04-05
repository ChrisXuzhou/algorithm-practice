package mostlikelyasked;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        // [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[][] matrix = {{1, 0}};

        new SetMatrixZeroes()
                .setZeroes(matrix);
    }

    public void setZeroes(int[][] matrix) {

        if (matrix == null || matrix.length < 1) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColumnHasZero = true;
                break;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // use the first element in row and column to identify the zero grids
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColumnHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
