import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		char[][] chessPlate = new char[N][M];
		
		for(int row = 0; row < N; row++) {
			String inRow = sc.next();
			for(int col = 0; col < M; col++) {
				chessPlate[row][col] = inRow.charAt(col);
			}
		}
		
		// 초기값에는 가장 큰 값 넣기. 최솟값 구할거니깐
		int res = Integer.MAX_VALUE;
		
		// 8x8로 자르기 위한 꼭짓점 정하기
		for(int row = 0; row < N-7; row++) {
			for(int col = 0; col < M-7; col++) {
				// 흰색으로 시작하는거랑 검은색으로 시작하는거 확인
				int whiteCnt = 0;
				int blackCnt = 0;
				// 크기가 8x8인거 만큼만 확인
				for(int i = row; i < row+8; i++) {
					for(int j = col; j < col+8; j++) {
						// 흰색 시작하는건 기초값이 W
						char compareW = 'W';
						// 검은색 시작하는건 기초값이 B
						char compareB = 'B';
						
						// 근데 (row + col) % 2 == 1 이라면 compareW는 B가 된다. compareB는 W가 된다
						if((i + j) % 2 == 1) {
							compareW = 'B';
							compareB = 'W';
						}
						
						// 만약 지금 위치랑 다르면 cnt늘리기
						if(chessPlate[i][j] != compareW) whiteCnt++;
						if(chessPlate[i][j] != compareB) blackCnt++;
					}
				}
				// 지금 확인한것중에 최적케이스를 구하고...
				int temp = Math.min(whiteCnt, blackCnt);
				// 이전 결과와 비교해서 작으면 갱신
				res = Math.min(res, temp);
			}
		}

		System.out.println(res);
	}
}
