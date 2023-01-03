import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] counts = new int[26];
        int cnt = Integer.valueOf(br.readLine());
        while (cnt-- > 0) {
            String name = br.readLine();
            counts[name.charAt(0) - 'a']++;
        }
        cnt = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] >= 5) {
                cnt++;
                bw.write((char) (i + 'a'));
            }
        }
        if (cnt == 0) {
            bw.write("PREDAJA");
        }
        bw.flush();
    }
}