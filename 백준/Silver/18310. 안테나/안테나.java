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

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] home = new int[N];

		for (int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(home);

		if (N % 2 == 0) {
			bw.write(home[N / 2 - 1] + "");
		} else {
			bw.write(home[N / 2] + "");
		}
		bw.flush();
		bw.close();
	}
}
