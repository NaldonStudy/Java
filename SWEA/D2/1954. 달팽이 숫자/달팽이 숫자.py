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
	
	// 우하좌상
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int ansCnt = 1; ansCnt <= T; ansCnt++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] snailArr = new int[N][N];
			
			snailArr[0][0] = 1;
			
			int way = 0;
			
			int i = 2;
			int r = 0, c = 0;
			while(i <= N*N) {
				while( (r + dr[way] >= 0) && (r+dr[way] < N) && (c+dc[way] >= 0) && (c + dc[way] < N)) { // 범위 안에 있는지 부터 확인
					if (snailArr[r+dr[way]][c+dc[way]] == 0) {
						snailArr[r+dr[way]][c+dc[way]] = i++;
						r+=dr[way];
						c+=dc[way];
					} else break;
				}
				if (way == 3) way = 0;
				else way++;
			}
			
			bw.write("#" + ansCnt + "\n");
			for(int idx = 0; idx < N; idx++) {
				for(int jdx = 0; jdx < N; jdx++) {
					bw.write(snailArr[idx][jdx] + " ");
				}
				bw.write("\n");
			}
			bw.flush();
		}
		bw.close();
		
	}
}