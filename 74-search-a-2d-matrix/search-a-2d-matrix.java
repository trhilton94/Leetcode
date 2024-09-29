class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int low = 0;
        int high = matrix[0].length - 1;
        int mid = 0;

        // Find row
        for (int m = 0; m < matrix.length; m++) {
            if (matrix[m][0] <= target && matrix[m][matrix[0].length - 1] >= target) {
                row = m;
            } // if
        } // for

        while (low <= high) {
            mid = (low + high) / 2;
            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] < target) {
                low = mid + 1;
            } else if (matrix[row][mid] > target) {
                high = mid - 1;
            } // if
        } // while

        return false;
    } // searchMatrix
} // Solution