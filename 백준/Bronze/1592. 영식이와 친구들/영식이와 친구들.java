import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer NML = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(NML.nextToken());
		int M = Integer.parseInt(NML.nextToken());
		int L = Integer.parseInt(NML.nextToken());
		
		int[] getBall = new int[N];
		
		int nowBallIdx = 0;
		int cnt = 0;
		
		while(true) {
			getBall[nowBallIdx]++;
			if (getBall[nowBallIdx] == M) break;
			else {
				if (getBall[nowBallIdx] % 2 == 0) {
					nowBallIdx = (nowBallIdx + (N-L)) % N;
					cnt++;
				} else {
					nowBallIdx = (nowBallIdx + L) % N;
					cnt++;
				}
			}
		}
		
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}
}