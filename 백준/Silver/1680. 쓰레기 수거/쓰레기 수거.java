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
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer WN = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(WN.nextToken());
			int N = Integer.parseInt(WN.nextToken());
		
			int dis = 0;
			int truckW = 0;
			
			for(int n = 0; n < N-1; n++) {
				StringTokenizer xiwi = new StringTokenizer(br.readLine());
				int x_i = Integer.parseInt(xiwi.nextToken());
				int w_i = Integer.parseInt(xiwi.nextToken());
				
				// 1. 쓰레기의 양이 용량에 도달했을 때
				if(truckW + w_i == W) {
					dis += x_i*2;
					truckW = 0;
					
				}
				// 2. 그 지점의 쓰레기를 실었을 때 쓰레기차의 용량을 넘게 될 때
				else if(truckW + w_i > W) {
					dis += x_i*2;
					truckW = w_i;
				} else {
					truckW += w_i;
				}
			}
			// 3. 더 이상 쓰레기를 실을 지점이 없을 때
			StringTokenizer xiwi = new StringTokenizer(br.readLine());
			int x_i = Integer.parseInt(xiwi.nextToken());
			int w_i = Integer.parseInt(xiwi.nextToken());
			
			// 마지막 지점인데 다시 왔다갔다 해야한다면
			if(truckW + w_i > W) {
				dis += x_i*4;
			}
			// 아니고 걍 가기만 하면 끝이라면
			else {
				dis += x_i*2;
			}
			
			bw.write(""+dis);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
	
}