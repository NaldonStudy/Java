import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	static int N, M, size;
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

		// 입력은 그대로 받아줌
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(inNum.nextToken());
		}

		Arrays.sort(numArr);

		sequence(0, 0);
		bw.write(sb + "");
		bw.flush();
		bw.close();
	}

	static void sequence(int idx, int sidx) {
		if (sidx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(resArr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		int before = 0;
		for (int i = idx; i < N; i++) {
			if (numArr[i] != before) {
//				visit[i] = true;
				before = numArr[i];
				resArr[sidx] = numArr[i];
				sequence(i, sidx + 1);
//				visit[i] = false;
			}
		}

	}
}
