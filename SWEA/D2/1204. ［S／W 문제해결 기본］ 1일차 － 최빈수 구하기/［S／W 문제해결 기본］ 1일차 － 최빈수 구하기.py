/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int caseNum = Integer.parseInt(br.readLine());
			int[] studentScore = new int[1000];
			
			StringTokenizer nums = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 1000; j++) {
				studentScore[j] = Integer.parseInt(nums.nextToken());
			}
			
			int[] scoreCnt = new int[101];
			int res = countingMax(studentScore, scoreCnt);
			bw.write("#" + caseNum + " " + Integer.toString(res) + "\n");
			bw.flush();
		}
		bw.close();	
	}
	
	static int countingMax (int[] studentScore, int[] scoreCnt) {
		for (int i = 0; i < studentScore.length; i++) {
			scoreCnt[studentScore[i]]++;
		}
		
		int max_Cnt = 0;
		int max_Idx = 0;
		for(int i = scoreCnt.length-1; i >= 0; i--) {
			if(scoreCnt[i] > max_Cnt) {
				max_Cnt = scoreCnt[i];
				max_Idx = i;
			}
		}
		return max_Idx;
	}
}