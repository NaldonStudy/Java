import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> price = new Stack<>();
        
        for (int tc = 0; tc < K; tc++) {
        	int p = Integer.parseInt(br.readLine());
        	if(p!=0) 
        		price.push(p);
        	else
        		price.pop();
        }
        
        int res = 0;
        while(!price.isEmpty()) {
        	res += price.pop();
        }
        bw.write(Integer.toString(res));
        bw.flush();
        bw.close();
    }
}
