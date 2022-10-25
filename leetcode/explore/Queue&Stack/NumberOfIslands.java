class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;    //row count;
        int n = grid[0].length; //col count;

        int result = 0;

        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    merge(grid, i, j);
                    result++;
                }
            }
        }

        return result;
    }

    public void merge(char[][] grid, int row, int col) {
        int m = grid.length;    //row count;
        int n = grid[0].length; //col count;
        if (row < m && col < n && row >= 0 && col >= 0 && grid[row][col] != '0') {
            grid[row][col] = '0';

            merge(grid, row, col + 1);
            merge(grid, row, col - 1);
            merge(grid, row + 1, col);
            merge(grid, row - 1, col);
        }
    }
}