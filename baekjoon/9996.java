import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Integer num = Integer.valueOf(s);
        String regex = br.readLine().replace("*", ".*");
        while(num-- > 0) {
            String str = br.readLine();
            if(Pattern.matches(regex, str)) bw.write("DA");
            else bw.write("NE");
            bw.newLine();
        }
        bw.flush();
    }
}