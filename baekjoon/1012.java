import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static Queue<List<Integer>> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nums = Integer.parseInt(br.readLine());
        while (nums-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int maxX = Integer.parseInt(st.nextToken());
            int maxY = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            board = new int[maxX][maxY];
            while(count-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }

            bw.write(String.valueOf(find()));
            bw.newLine();
        }
        bw.flush();
    }

    public static int find() {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[i].length; j++) {
                if (board[i][j] != 0) {
                    count++;
                    fill(i, j, queue);
                }
            }
        }
        return count;
    }

    public static void fill(int x, int y, Queue<List<Integer>> queue) {
        board[x][y] = 0;
        queue.offer(List.of(x, y));
        while(!queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.get(0) + dx[i];
                int ny = poll.get(1) + dy[i];
                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[x].length) continue;
                if (board[nx][ny] == 0) continue;
                board[nx][ny] = 0;
                queue.offer(List.of(nx, ny));
            }
        }
    }
}