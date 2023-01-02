import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //level
        String str = br.readLine();
        int isPal = 1;
        for (int i = 0; i <= str.length() / 2; i++) {
            int right = str.length() - 1 - i;
            if (str.charAt(i) != str.charAt(right)) {
                isPal = 0;
                break;
            }
        }
        bw.write(String.valueOf(isPal));
        bw.flush();

    }
}