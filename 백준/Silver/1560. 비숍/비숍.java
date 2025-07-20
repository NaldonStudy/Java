import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		BigInteger N = new BigInteger(br.readLine());
		BigInteger res;
		
		if(N.equals(BigInteger.valueOf(1))) {
			res = BigInteger.valueOf(1);
		} else {
			res = N.multiply(BigInteger.TWO).subtract(BigInteger.TWO);
		}
		
		bw.write("" + res);
		bw.flush();
		bw.close();
	}
}