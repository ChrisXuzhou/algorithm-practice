package mostlikelyasked;

public class Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        int row = 0;
        int column = columns - 1;

        while (row < rows && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                row ++;
            } else {
                column --;
            }
        }
        return false;
    }

}
