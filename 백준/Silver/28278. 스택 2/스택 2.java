import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int t = 0; t<N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int caseNum = Integer.parseInt(st.nextToken());
			
			switch (caseNum) {
			case 1: 
				int pushNum = Integer.parseInt(st.nextToken());
				stack.push(pushNum);
				break;
			case 2:
				if(stack.isEmpty()){
					bw.write("-1\n");
					bw.flush();
					break;
				}
				bw.write(stack.pop() + "\n");
				bw.flush();
				break;
			case 3:
				bw.write(stack.size() + "\n");
				bw.flush();
				break;
			case 4:
				if(stack.isEmpty()) {
					bw.write("1\n");
					bw.flush();
					break;
				}
				bw.write("0\n");
				bw.flush();
				break;
			case 5:
				if(stack.isEmpty()) {
					bw.write("-1\n");
					bw.flush();
					break;
				}
				bw.write(stack.peek() + "\n");
				bw.flush();
				break;
			}
		

		}
		bw.close();
	}
}