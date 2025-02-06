import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = 0;
		int N = sc.nextInt();

		for (int TH = 2; TH <= N - 4; TH += 2) {
			int YH = 1;
			int NG = N - TH - YH;
			while (NG - YH > 1) {
				cnt++;
				YH++;
				NG--;
			}
		}
		System.out.println(cnt);

	}
}