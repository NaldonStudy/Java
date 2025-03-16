import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static StringBuilder sb;
	static int[] numArr, resArr;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numArr = new int[N];
		resArr = new int[M];
		visit = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			numArr[i] = i+1;
		}
		sequence(0);
		bw.write(sb+"");
		bw.flush();
		bw.close();
	}
	
	static void sequence(int sidx) {
		if (sidx == M) {
			for(int i = 0; i < M; i++) {
				sb.append(resArr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int idx = 0; idx < N; idx++) {
			if(!visit[idx]) {
				visit[idx] = true;
				resArr[sidx] = numArr[idx];
				sequence(sidx+1);
				visit[idx] = false;
			}
		}
		
	}
}
