class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Stack<List> stack = new Stack<>();
        List<Integer> index = new ArrayList<>();
        HashSet<List> visit = new HashSet<>();

        int m = image.length;
        int n = image[0].length;

        int startColor = image[sr][sc];

        index.add(sr);
        index.add(sc);
        stack.push(index);

        while (!stack.isEmpty()) {
            List<Integer> cur = stack.pop();
            int row = cur.get(0);
            int col = cur.get(1);
            if (!visit.contains(cur) && image[row][col] == startColor) {
                visit.add(cur);
                image[row][col] = color;

                if (row - 1 >= 0) {
                    index = new ArrayList<>();
                    index.add(row - 1);
                    index.add(col);
                    stack.push(index);
                }
                if (row + 1 < m) {
                    index = new ArrayList<>();
                    index.add(row + 1);
                    index.add(col);
                    stack.push(index);
                }
                if (col - 1 >= 0) {
                    index = new ArrayList<>();
                    index.add(row);
                    index.add(col - 1);
                    stack.push(index);
                }
                if (col + 1 < n) {
                    index = new ArrayList<>();
                    index.add(row);
                    index.add(col + 1);
                    stack.push(index);
                }
            }
        }

        return image;
    }
}