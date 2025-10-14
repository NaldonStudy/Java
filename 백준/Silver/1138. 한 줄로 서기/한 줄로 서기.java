import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[N];
        int[] res = new int[N];

        StringTokenizer inNum = new StringTokenizer(br.readLine());

        // 인풋 받아서 실행
        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(inNum.nextToken());

            // 돌면서 방문처리한 곳 어딘지 확인하기
            // 들어온 숫자가 방문처리 안한곳 숫자 넘으면 거기가 걔 자리임
            int cnt = 0;
            for(int j = 0; j < N; j++) {
                // 방문 안한곳이면서 cnt랑 들어온 숫자랑 같다면 그 위치가 해당 숫자의 위치임
                if(!visited[j] && cnt == temp) {
                    visited[j] = true;
                    res[j] = i+1;
                    break;
                } else if(!visited[j]) cnt++;
            }
        }

        for(int i = 0; i < N; i++) {
            bw.write(res[i] + " ");
        }
        bw.flush();
    }
}
