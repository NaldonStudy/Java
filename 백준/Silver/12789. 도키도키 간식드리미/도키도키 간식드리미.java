import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Stack<Integer> temp = new Stack<>();
        int cnt = 1; // 원하는 간식 번호
        
        for (int i = 0; i < N; i++) {
            int student = Integer.parseInt(st.nextToken());
            
            if (student == cnt) { // 원하는 번호라면 바로 간식 주기
                cnt++;
            } else {
                temp.push(student); // 스택에 보관
            }
            
            // 스택에서 확인하여 간식 줄 수 있는 경우 계속 꺼내기
            while (!temp.isEmpty() && temp.peek() == cnt) {
                temp.pop();
                cnt++;
            }
        }
        
        // 스택이 비어 있으면 성공
        bw.write(temp.isEmpty() ? "Nice" : "Sad");
        bw.flush();
        bw.close();
    }
}