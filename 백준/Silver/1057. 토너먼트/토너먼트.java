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
		
		int N = Integer.parseInt(st.nextToken());
		int Kim = Integer.parseInt(st.nextToken());
		int Lim = Integer.parseInt(st.nextToken());
		
		int adjKim = Kim - 1;
		int adjLim = Lim - 1;
		int round = 1;
		
		while((int) Math.pow(2, round) <= N) {
			int div = (int) Math.pow(2, round);
			int tempK = adjKim / div;
			int tempL = adjLim / div;
			
			if(tempK == tempL) break;
			
			round++;
		}
		
		bw.write("" + round);
		bw.flush();
		bw.close();
	}
}
