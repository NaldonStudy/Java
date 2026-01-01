import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static StringBuilder sb;
	static int[] numArr, resArr;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer NM = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(NM.nextToken());
		M = Integer.parseInt(NM.nextToken());

		numArr = new int[N];
		resArr = new int[M];
		visit = new boolean[N];

		StringTokenizer inNum = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(inNum.nextToken());
		}
		Arrays.sort(numArr);

		sequence(0);
		bw.write(sb + "");
		bw.flush();
		bw.close();
	}

	static void sequence(int sidx) {
		if (sidx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(resArr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
//			if (!visit[i]) {
//				visit[i] = true;
			resArr[sidx] = numArr[i];
			sequence(sidx + 1);
//				visit[i] = false;
//			}
		}

	}
}
