import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] N = sc.nextLine().split(":");

		int[] results = new int[2];

		List<List<Integer>> lists = new ArrayList<>();

		int[][] keypad = { { 3, 1 }, { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 }, { 2, 1 },
				{ 2, 2 } };

		for (int i = 0; i < 2; i++) {
			int time = 0;
			int c = (i == 0) ? 24 : 60;
			int tmp_rest = Integer.parseInt(N[i]) % c;
			
			List<Integer> tmp_list = new ArrayList<>();
			
			for(int j = 0; time < 100; j++) {
				time = (c*j) + tmp_rest;
				if(time >= 100) break;
				tmp_list.add(time);
			}
			
			lists.add(tmp_list);
			
		}
		
		int cases = lists.get(0).size() * lists.get(0).size();
		int min_dis = 100;
		for(int i = 0; i <  lists.get(0).size(); i++) {
			int n2 = lists.get(0).get(i) % 10;
			int n1 = (int)((lists.get(0).get(i) / 100.0) * 10.0);
			int cur_dis;
			for(int j = 0; j <  lists.get(1).size(); j++) {
				int n4 = lists.get(1).get(j) % 10;
				int n3 = (int)((lists.get(1).get(j) / 100.0) * 10.0);
				
				cur_dis = Math.abs(keypad[n1][0] - keypad[n2][0]) + Math.abs(keypad[n1][1] - keypad[n2][1]) +
				Math.abs(keypad[n2][0] - keypad[n3][0]) + Math.abs(keypad[n2][1] - keypad[n3][1]) +
				Math.abs(keypad[n3][0] - keypad[n4][0]) + Math.abs(keypad[n3][1] - keypad[n4][1]);
				
				if(min_dis > cur_dis) {
					min_dis = cur_dis;
					
					results[0] = lists.get(0).get(i);
					results[1] = lists.get(1).get(j);
				}
			}
		}
		
		System.out.printf("%02d:%02d" ,results[0], results[1]);

		
	}
}
