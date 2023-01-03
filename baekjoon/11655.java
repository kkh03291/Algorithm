import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        for(Character c : str.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (Character.isUpperCase(c)) bw.write(encoding(c , 'A', 'Z'));
                else bw.write(encoding(c, 'a', 'z'));
            } else {
                bw.write(c);
            }
        }
        bw.flush();
    }
    public static char encoding(char c, char a, char z) {
        int i = c - '0';
        i += 13;
        if (i > z - '0') {
            i %= z - '0';
            i--;
            i += a - '0';
        }
        return (char) (i + '0');
    }
}