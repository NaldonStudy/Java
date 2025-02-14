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
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			Stack<Character> Bracket = new Stack<>();
			String inBracket = br.readLine();
			
			String res = "YES";
			for (int i = 0; i < inBracket.length(); i++) {
				if (inBracket.charAt(i) == '(') {
					Bracket.push(inBracket.charAt(i));
				} else if (!Bracket.isEmpty() && inBracket.charAt(i) == ')') {
					Bracket.pop();
				} else {
					res = "NO";
					break;
				}
			}
			if (!Bracket.isEmpty())
				res = "NO";
			
			bw.write(res + "\n");
			bw.flush();
		}
		bw.close();
	}
}