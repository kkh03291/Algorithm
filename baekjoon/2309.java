import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> res = new ArrayList<>();
    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(Integer.valueOf(br.readLine()));
        }

        find(list);
        res.sort(Integer::compareTo);
        for (Integer item : res) {
            bw.write(String.valueOf(item));
            bw.newLine();
        }
        bw.flush();
    }

    public static void find(List<Integer> list) {
        if (res.size() > 7 || total > 100 || list.isEmpty()) {
            return;
        }


        for (Integer i : list) {
            res.add(i);
            total += i;
            find(list.subList(list.indexOf(i) + 1, list.size()));
            if (res.size() == 7 && total == 100) {
                return;
            }
            res.remove(i);
            total -= i;
        }
    }
}