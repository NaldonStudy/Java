import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;
 
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();	// 출력할 결과물 저장
		
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		int start = 0;
		boolean res = true;
		// N 번 반복
		for (int i = 0; i < N; i++) {
		    int value = Integer.parseInt(br.readLine());
		    
		    if (value > start) {
		        // start + 1부터 입력받은 value까지 push
		        for (int j = start + 1; j <= value; j++) {
		            stack.push(j);
		            sb.append('+').append('\n'); // +를 저장
		        }
		        start = value; // 다음 push를 위한 변수 초기화
		    } 
		    // top에 있는 원소가 입력받은 값과 다를 경우
		    else if (stack.peek() != value) {
		        res = false;
		        break;
		    }
		    
		    stack.pop();
		    sb.append('-').append('\n');
		}
		if (res) {
			bw.write(sb.toString());
		} else {
			bw.write("NO\n");
		}
		bw.flush();
		bw.close();
	}
}