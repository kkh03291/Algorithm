import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, board[i][j]);
            }
        }

        int ret = 1;
        for (int i = 0; i < max; i++) {
            ret = Math.max(ret, check(board, i));
        }

        bw.write(String.valueOf(ret));
        bw.flush();

    }

    public static int check(int[][] board, int height) {
        int N = board.length;
        int[][] visit = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] <= height && visit[i][j] == 0) {
                    visit[i][j] = 1;
                    bfs(board, visit, i, j, height);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visit[i][j] == 0) {
                    visit[i][j] = 1;
                    count++;
                    bfs(visit, visit, i, j, 0);
                }
            }
        }
        return count;
    }

    public static void bfs(int[][] board, int[][] visit, int x, int y, int height) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(x,y));
        while(!queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.get(0) + dx[i];
                int ny = poll.get(1) + dy[i];
                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board.length) continue;
                if (board[nx][ny] <= height && visit[nx][ny] == 0) {
                    visit[nx][ny] = 1;
                    queue.offer(List.of(nx, ny));
                }
            }
        }
    }
}