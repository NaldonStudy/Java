import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean res = false;
		
		for (int i = 0; i <= N / A; i++) {
			for (int j = 0; j <= (N - i * A) / B; j++) {
				int temp = i * A + j * B;
				if (temp <= N && (N - temp) % C == 0) {
					res = true;
					break;
				}
			}
			if (res) break;
		}
		
		bw.write(res ? "1" : "0");
		bw.flush();
		bw.close();
	}
}
