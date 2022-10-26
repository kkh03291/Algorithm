class Solution {
    public int numSquares(int n) {
        HashSet<Integer> squares = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        for (int i = 1; i < n; i++) {
            int pow = (int) Math.pow(i,2);
            if (pow > n) break;
            squares.add(pow);
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                int poll = queue.poll();
                if (poll == n) return level;

                for (int s : squares) {
                    int tmp = poll + s;
                    if (tmp > n) {
                        continue;
                    }
                    if (tmp == n) return ++level;
                    queue.offer(tmp);
                }
                size--;
            }
            level++;
        }
        return level;
    }
}