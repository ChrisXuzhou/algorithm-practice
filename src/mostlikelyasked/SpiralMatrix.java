package mostlikelyasked;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {


    public static void main(String[] args) {
        // [1,2,3,4],[5,6,7,8],[9,10,11,12]
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{2, 5, 8}, {4, 0, -1}};
        List<Integer> ret = new SpiralMatrix()
                .spiralOrder(matrix);

        System.out.println(ret.size());

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

//        spiral(ret, matrix, 1);

        int half = (Math.min(m, n) - 1) / 2;
        for (int k = 0; k < half; k++) {
            spiral(ret, matrix, k);
        }

        return ret;
    }

    private void spiral(List<Integer> ret, int[][] matrix, int k) {

        int m = matrix.length;
        int n = matrix[0].length;

        // i: k ---> m - k - 1
        // j: k ---> n - k - 1

        for (int j = k; j <= n - k - 1; j++) {
            ret.add(matrix[k][j]);
        }
        for (int i = k + 1; i <= m - k - 1; i++) {
            ret.add(matrix[i][n - k - 1]);
        }

        if (m - k - 1 > k) {
            for (int j = n - k - 2; j >= k; j--) {
                ret.add(matrix[m - k - 1][j]);
            }
        }

        if (n - k - 1 > k) {
            for (int i = m - k - 2; i > k; i--) {
                ret.add(matrix[i][k]);
            }
        }

    }


}
