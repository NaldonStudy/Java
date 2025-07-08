import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int res = 0;

        if (N == 1) {
            res = 1;
        } else if(N == 2) {
            if(M < 9) {
                res = (M + 1) / 2;
            } else {
                res = 4;
            }
        } else {
            if(M < 5) {
                res = M;
            } else if (M < 7) {
                res = 4;
            } else {
                res = M - 2;
            }
        }

        bw.write(""+res);
        bw.flush();
        bw.close();
    }
}
