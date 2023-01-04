import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<List<Integer>> queue = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        String s = br.readLine();
        String[] s1 = s.split(" ");
        int maxX = Integer.parseInt(s1[0]);
        int maxY = Integer.parseInt(s1[1]);
        int[][] board = new int[maxX][maxY];

        for (int i = 0; i < board.length; i++) {
            String s2 = br.readLine();
            for (int j = 0; j < s2.length(); j++) {
                board[i][j] = s2.charAt(j) - '0';
            }
        }

        queue.offer(List.of(0, 0));
        while(!queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            int x = poll.get(0);
            int y = poll.get(1);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= maxX || ny < 0 || ny >= maxY) continue;
                if (board[nx][ny] == 0) continue;
                if (board[nx][ny] == 1) {
                    queue.offer(List.of(nx, ny));
                    board[nx][ny] = board[x][y] + 1;
                }
            }
        }

        bw.write(String.valueOf(board[--maxX][--maxY]));
        bw.flush();
    }
}