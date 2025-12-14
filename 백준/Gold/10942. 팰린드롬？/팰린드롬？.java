import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 보드에 써진 수 부터 담자
        int N = Integer.parseInt(br.readLine());
        int[] board = new int[N];
        StringTokenizer boardNum = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            board[i] = Integer.parseInt(boardNum.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        // M번동안 반복
        for(int i = 0; i < M; i++) {
            StringTokenizer SE = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(SE.nextToken());
            int E = Integer.parseInt(SE.nextToken());

            int res = 1;

            // 실제 위치랑 맞춰야하니깐 변형주기
            S--;
            E--;

            while (S < E) {
                // 1. 둘이 다르면 팰린드롬이 아니다.
                if(board[S] != board[E]) {
                    res = 0;
                    break;
                }

                // 2. 위에가 아니면 둘은 같다는 뜻
                S++;
                E--;
            }

            bw.write(res + "\n");
        }
        bw.flush();
        bw.close();
    }
}