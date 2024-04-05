package mostlikelyasked;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new RotateImage()
                .rotate(matrix);


        System.out.println(matrix.length);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i < n - 1 - j) {
//                    System.out.println(i + "," + j);
                    rotate(matrix, i, j, n);
                }
            }
        }

    }

    private void rotate(int[][] matrix, int i, int j, int n) {

        int tmp = matrix[i][j];

        matrix[i][j] = matrix[n - j - 1][i];
        matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
        matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
        matrix[j][n - i - 1] = tmp;
    }
}
