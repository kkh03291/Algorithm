import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = 0;
        String str = br.readLine();
        String[] pee = str.split(" ");
        int[] cars = new int[101];

        for (int i = 0; i < 3; i++) {
            str = br.readLine();
            String[] indexs = str.split(" ");
            for (int j = Integer.valueOf(indexs[0]);
                 j < Integer.valueOf(indexs[1]); j++) {
                cars[j] += 1;
            }
        }

        for (int car : cars) {
            if (car != 0) {
                total += Integer.valueOf(pee[car - 1]) * car;
            }
        }

        bw.write(String.valueOf(total));
        bw.flush();
    }
}