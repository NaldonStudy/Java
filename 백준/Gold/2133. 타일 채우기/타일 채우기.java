import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // N이 홀수면 불가
        if (N % 2 != 0) {
            bw.write("0");
        } else {
            int[] dp = new int[N + 1];

            // 초기값 설정
            dp[0] = 1;
            dp[2] = 3;

            // 점화식
            for (int i = 4; i <= N; i += 2) {
                // 이전 단계(i-2)에 3x2 타일 붙이기
                dp[i] = dp[i - 2] * 3;

                // 가운데에 빈 좀 다른모양 에 고유 모양 2개씩 붙이기
                for (int j = i - 4; j >= 0; j -= 2) {
                    dp[i] += dp[j] * 2;
                }
            }


            bw.write(""+dp[N]);
        }
        bw.flush();
        bw.close();
    }
}