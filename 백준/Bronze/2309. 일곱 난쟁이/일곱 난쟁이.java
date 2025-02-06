import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] hobit = new int[9];
		
		for (int i = 0; i < 9; i++) {
			hobit[i] = Integer.parseInt(br.readLine());
		}
		
		int sumAll = 0;
		for (int i = 0; i < 9; i++) {
			sumAll += hobit[i];
		}
		fin:
		for (int i = 0; i < 8; i++) {
			for (int j = i+1; j < 9; j++) {
				if (sumAll-hobit[i]-hobit[j] == 100) {
					hobit[i] = 100;
					hobit[j] = 100;
					break fin;
				}
			}
		}
		
		Arrays.sort(hobit);
		
		for (int i = 0; i < 7; i++) {
			bw.write(String.valueOf(hobit[i]));
			bw.write("\n");
		}
		bw.flush();
		bw.close();		
	}

}
