import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		HashMap<Integer, Integer> checklist = new HashMap<>();//해쉬 맵
		for (int i = 0; i < a; i++) {
			int num = sc.nextInt();
			checklist.put(num, checklist.getOrDefault(num, 0) + 1);//put(num, a)->num(key),a(value)를 넣음
		}//a.getordefault(b,defaultvalue)->a 에서 키가 b인 value값 없다면 default값 
		int b = sc.nextInt();
		int[] checking = new int[b];
		for (int i = 0; i < b; i++) {
			checking[i] = sc.nextInt();
		}
		for (int i = 0; i < b; i++) {
			if (checklist.get(checking[i]) == null)//없는 key값을 찾으면 value는 null이 나오니까 
				System.out.println(0);//없으면 0출력
			else
				System.out.println(1);//값이 있으면 1 출력

		}
	}
}