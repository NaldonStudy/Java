import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] board = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        // dp[S][E]: S부터 E까지 팰린드롬이면 true
        boolean[][] dp = new boolean[N + 1][N + 1];

        // 1. 길이가 1인 경우 (자기 자신)
        for(int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }

        // 2. 길이가 2인 경우 (연속된 두 수가 같을 때)
        for(int i = 1; i < N; i++) {
            if(board[i] == board[i+1]) {
                dp[i][i+1] = true;
            }
        }

        // 3. 길이가 3 이상인 경우
        // len: 구간의 길이
        for(int len = 3; len <= N; len++) {
            // i: 시작점
            for(int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1; // j: 끝점

                // 양 끝이 같고 && 그 사이(속)가 팰린드롬이면 true
                if(board[i] == board[j] && dp[i+1][j-1]) {
                    dp[i][j] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if(dp[S][E]) sb.append("1\n");
            else sb.append("0\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}