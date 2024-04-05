package mostlikelyasked;

public class SearchA2DMatrix {

    public static void main(String[] args) {
        // [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
//        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        // [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
//        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        int[][] matrix = {{1, 3}};

        System.out.println(
                new SearchA2DMatrix()
                        .searchMatrix(matrix, 2)
        );

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length < 1) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        if (matrix[0][0] > target) return false;

        int i = searchRow(matrix, target, 0, m - 1, n -1);
        if (i >= 0) {
            int j = searchColumn(matrix, target, 0, n - 1, i);
            return j >= 0;
        }

        return false;
    }

    int searchRow(int[][] matrix, int target, int start, int end, int n) {
        if (start > end) return -1;

        int mid = (start + end) / 2;

        if (matrix[mid][0] > target) {
            return searchRow(matrix, target, start, mid - 1, n);
        } else {
            // matrix[mid][0] <= target

            if (matrix[mid][n] < target) {
                return searchRow(matrix, target, mid + 1, end, n);
            } else {
                return mid;
            }
        }
    }

    int searchColumn(int[][] matrix, int target, int start, int end, int i) {
        if (start > end) return -1;

        int mid = (start + end) / 2;

        if (matrix[i][mid] == target) {
            return mid;
        } else if (matrix[i][mid] > target) {
            return searchColumn(matrix, target, start, mid - 1, i);
        } else {
            return searchColumn(matrix, target, mid + 1, end, i);
        }
    }
}
