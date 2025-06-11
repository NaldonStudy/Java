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
		
		int[] arr = new int[10];
		int res = 0;
		
		String[] strArr = br.readLine().split("");
		
		for(int cnt = 0; cnt < strArr.length; cnt++) {
			int tmpNum = Integer.parseInt(strArr[cnt]);
			
			if(tmpNum == 6 || tmpNum == 9) {
				if(arr[6] < arr[9]) {
					arr[6]++;
					if(res < arr[6]) res = arr[6];
				} else {
					arr[9]++;
					if(res < arr[9]) res = arr[9];
				}
				continue;
			}
			
			arr[tmpNum]++;
			if(res < arr[tmpNum]) res = arr[tmpNum]; 
		}
		
		bw.write(""+res);
		bw.flush();
		bw.close();
	}
}