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

        while (true) {
        	String str = br.readLine();
        	if (str.equals("."))
        		break;
        	Stack<Character> bracket = new Stack<>();
        	boolean res = true;
        	
        	for(int i = 0; i < str.length()-1; i++) {
        		char temp = str.charAt(i);
        		if(temp == '(' || temp == '[') {
        			bracket.push(temp);
        		} else if (temp == ')' || temp == ']') {
        			if (bracket.isEmpty()) {	// 비어있는데 닫으려하면?
        				res = false;
        				break;
        			}
        			if(temp == ')' && bracket.pop() != '(') {
        				res = false;
        				break;
        			} else if (temp == ']' && bracket.pop() != '[') {
        				res = false;
        				break;
        			}
        		}
        	}
        	if (res && bracket.isEmpty()) 
        		bw.write("yes\n");
        	else
        		bw.write("no\n");
        	bw.flush();
        }
        bw.close();
    }
}
