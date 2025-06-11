import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		res = 1;
		
		factorial(num);
		
		bw.write(""+res);
		bw.flush();
		bw.close();
		
	}
	
	static void factorial(int inNum) {
		if(inNum <= 1) {
			return;
		}
		
		factorial(inNum - 1);
		
		res *= inNum; 
	}
}