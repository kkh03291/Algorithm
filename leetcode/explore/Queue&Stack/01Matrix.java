class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length; //row
        int n = mat[0].length;  //col

        Queue<List> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(getIndex(i,j));
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int length = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            length++;
            while (size-- > 0) {
                List<Integer> index = queue.poll();
                for (int[] dir : dirs){
                    int row = index.get(0) + dir[0];
                    int col = index.get(1) + dir[1];
                    if (row < 0 || col < 0 || row >= m || col >= n || mat[row][col] != -1) {
                        continue;
                    }
                    mat[row][col] = length;
                    queue.offer(getIndex(row,col));
                }
            }
        }

        return mat;
    }

    public List<Integer> getIndex (int row, int col) {
        List<Integer> index = new ArrayList<>();
        index.add(row);
        index.add(col);
        return index;
    }
}