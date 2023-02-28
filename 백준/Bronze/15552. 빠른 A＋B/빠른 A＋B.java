import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        for (int i = 0; i < a; i++) {
            StringTokenizer num1 = new StringTokenizer(br.readLine(), " ");
            bw.write((Integer.parseInt(num1.nextToken())) + Integer.parseInt(num1.nextToken()) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}