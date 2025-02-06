import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int ans = 1;
		
		if (n == 1) ans = 1;
		else {
			int temp = n-2;
			int cnt = 1;
			while(true) {
				ans++;
				temp = temp - (6*cnt++);
				if (temp<0) {
					break;
				}
			}
		}
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();		
	}

}