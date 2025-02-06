import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int resTemp = (N-1) % 8;
		int res = 0;
		if(resTemp > 4)
			res = 5 - (resTemp-4);
		else
			res = resTemp+1;
		
		System.out.println(res);
		
	}

}