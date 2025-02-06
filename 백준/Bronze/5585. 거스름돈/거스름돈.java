import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int price = Integer.parseInt(bf.readLine());
		int change = 1000 - price;
		int cnt = 0;
		
		while(change > 4) {
			if (change >= 500) {
				int temp = change / 500;
				cnt += temp;
				change = change % 500;
			} else if (change >= 100) {
				int temp = change / 100;
				cnt += temp;
				change = change % 100;
			} else if (change >= 50) {
				int temp = change / 50;
				cnt += temp;
				change = change % 50;
			} else if (change >= 10) {
				int temp = change / 10;
				cnt += temp;
				change = change % 10;
			} else if (change >= 5) {
				int temp = change / 5;
				cnt += temp;
				change = change % 5;
			}
		}
		cnt += change;
		
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}
}