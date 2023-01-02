import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] res = new int[26];
        String str = br.readLine();
        for(Character c : str.toCharArray()) {
            int index = c - 'a';
            res[index] += 1;
        }

        for (int i : res) {
            bw.write(String.valueOf(i) + " ");
        }
        bw.flush();
    }
}