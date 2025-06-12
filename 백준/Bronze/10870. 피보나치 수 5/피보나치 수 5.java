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
		
		int inNum = Integer.parseInt(br.readLine());
		
		int res = dpFivo(inNum);
		
		bw.write(""+res);
		bw.flush();
		bw.close();
	}
	
	static int dpFivo(int num) {
		if(num == 0) 
			return 0;
		
		int[] dp = new int[num+1];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= num; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[num];
	}
}