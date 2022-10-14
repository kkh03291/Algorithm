class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[m - 1].length;

        int[] result = new int[m*n];

        int row = 0;
        int col = 0;
        int count = 0;
        boolean direction = true; // up : true, down : false
        while (count < m*n) {
            result[count] = mat[row][col];
            mat[row][col] = Integer.MIN_VALUE;
            if (direction) {
                // up
                if (row - 1 >= 0 && col + 1 < n) {
                    row--;
                    col++;
                }else {
                    direction = false;
                    if (col + 1 < n) {
                        col++;
                    }else {
                        row++;
                    }
                }
            }else {
                //down
                if (col - 1 >= 0 && row + 1 < m) {
                    col--;
                    row++;
                }else {
                    direction = true;
                    if (row + 1 < m) {
                        row++;
                    }else {
                        col++;
                    }
                }
            }
            count++;
        }
        return result;
    }
}