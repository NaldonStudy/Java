import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static final int[] XCOOR = { 1, 0, 1, 2, 0, 1, 2, 0, 1, 2 };
    static final int[] YCOOR = { 3, 0, 0, 0, 1, 1, 1, 2, 2, 2 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), ":");

        int inH = Integer.parseInt(st.nextToken());
        int inM = Integer.parseInt(st.nextToken());


        int H = inH % 24;
        int M = inM % 60;
        int minCnt = Integer.MAX_VALUE, minH = 0, minM = 0;

        for (int i = H; i < 100; i += 24) {
            for (int j = M; j < 100; j += 60) {
                int[] numArr = { i / 10, i % 10, j / 10, j % 10 };
                int cnt = 0;

                for (int k = 0; k < 3; k++) {
                    cnt += Math.abs(XCOOR[numArr[k]] - XCOOR[numArr[k + 1]]);
                    cnt += Math.abs(YCOOR[numArr[k]] - YCOOR[numArr[k + 1]]);
                }

                if (cnt < minCnt) {
                    minCnt = cnt;
                    minH = i;
                    minM = j;
                }
            }
        }

        bw.write(String.format("%02d:%02d", minH, minM));
        bw.flush();
        bw.close();
    }
}
