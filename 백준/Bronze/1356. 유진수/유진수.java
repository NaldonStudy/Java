import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arrNum = Stream.of(String.valueOf(N).split("")).mapToInt(Integer::parseInt).toArray();
		boolean uJeans = false;
		
		for (int i=1; i < arrNum.length; i++) {
			long front = 1;
			long back = 1;
			for (int a = 0; a < i; a++) {
				front *= arrNum[a];
			}
			for (int b = 0; b < arrNum.length - i; b++) {
				back *= arrNum[arrNum.length - b - 1];
			}
			if (front == back) {
				System.out.println("YES");
				uJeans = true;
				break;
			}
		}
		if (uJeans == false) System.out.println("NO");
		
		
	}

}
