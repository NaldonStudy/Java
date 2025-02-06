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

		int switchCnt = Integer.parseInt(br.readLine());
		StringTokenizer inCnt = new StringTokenizer(br.readLine());
		int[] arr = new int[switchCnt];

		for (int i = 0; i < switchCnt; i++) {
			arr[i] = Integer.parseInt(inCnt.nextToken());
		}

		int studentCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < studentCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int sex = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());

			switch (sex) {
			case 1:	
				int range = arr.length / point;
				for(int j = 1; j <= range; j++) {
					if (arr[point*j-1] == 0) 
						arr[point*j-1] = 1;
					else arr[point*j-1] = 0;
				}
				break;
				
			case 2:
				int cnt = 1;
				point--;
				if (arr[point] == 0) arr[point] = 1;
				else arr[point] = 0;
				while(point-cnt >= 0 && point+cnt < arr.length && arr[point-cnt] == arr[point+cnt]) {
					if (arr[point-cnt] == 0) arr[point-cnt] = 1;
					else arr[point-cnt] = 0;
					if (arr[point+cnt] == 0) arr[point+cnt] = 1;
					else arr[point+cnt] = 0;
					cnt++;
				}
				break;
			}
		}
		for (int idx = 0; idx < arr.length; idx++) {
			bw.write(String.valueOf(arr[idx]));
			if ((idx+1) % 20 == 0) bw.write("\n");
			else bw.write(" ");
		}
		bw.flush();
		bw.close();
	}
}
