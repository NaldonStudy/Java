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
		
		int arrLen = Integer.parseInt(br.readLine());
		int[] arr = new int[arrLen];
		
		StringTokenizer inNums = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < arrLen; i++) {
			arr[i] = Integer.parseInt(inNums.nextToken());
		}
		
		int sumRes = Integer.parseInt(br.readLine());
		int res = 0;
		
		for(int i = 0; i < arrLen - 1; i++) {
			if(arr[i] >= sumRes) continue;
			for(int j = i+1; j < arrLen; j++) {
				if(arr[i] + arr[j] == sumRes) {
					res++;
					break;
				}
			}
		}
		
		bw.write("" + res);
		bw.flush();
		bw.close();
	}
}