import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inStr = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < inStr.length(); i++) {
            char temp = inStr.charAt(i);

            if (temp >= 'A' && temp <= 'Z') { // 알파벳이면 바로 출력
                sb.append(temp);
            } else if (temp == '(') {
                stack.push(temp);
            } else if (temp == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); // '(' 제거
            } else { // 연산자 처리
                while (!stack.isEmpty() && compare(stack.peek()) >= compare(temp)) {
                    sb.append(stack.pop());
                }
                stack.push(temp);
            }
        }

        // 스택에 남아 있는 연산자 출력
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int compare(char op) {
        if (op == '*' || op == '/') return 2;
        else if (op == '+' || op == '-') return 1;
        else return 0;	//(에 대비해서 만들어둔거
    }
}
