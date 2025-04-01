import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] saejun = new int[2][N+1];
        
        StringTokenizer hp = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
        	saejun[0][i] = Integer.parseInt(hp.nextToken());
        }
        
        StringTokenizer happy = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
        	saejun[1][i] = Integer.parseInt(happy.nextToken());
        }
        
        int[][] dp = new int[N+1][100];
        
        // i는 사람의 수만큼 돌겠다 라는 뜻
        for (int i = 1; i <= N; i++) {
        	// j는 체력에 관한 이야기
            for (int j = 1; j < 100; j++) {
            	// 해당 체력이 들어갈 수 있는 경우
                if (saejun[0][i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - saejun[0][i]] + saejun[1][i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        bw.write("" + dp[N][99]);
        bw.flush();
        bw.close();
    }
}