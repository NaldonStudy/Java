import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static boolean[][] bingo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        board = new int[5][5];
        bingo = new boolean[5][5];

        for(int row = 0; row < 5; row++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int col = 0; col < 5; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;

        loop:
        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                int temp = Integer.parseInt(st.nextToken());
                findWhere(temp);

                // 3빙고는 13부터 나올 수 있음
                if((5*i + (j+1)) < 10) continue;

                int bingoCnt = 0;
                bingoCnt = countBingo();

                if(bingoCnt > 2) {
                    res = (5 * i) + (j + 1);
                    break loop;
                }
            }
        }

        bw.write(""+res);
        bw.flush();
        bw.close();
    }

    // 어디에 숫자가 있는지 확인 이후 기록
    static void findWhere(int num) {
        loop:
        for(int row = 0; row < 5; row++) {
            for(int col = 0; col < 5; col++) {
                if(bingo[row][col]) continue;
                if(board[row][col] == num) {
                    bingo[row][col] = true;
                    break loop;
                }
            }
        }
    }

    static int countBingo() {
        int cnt = 0;

        // 행 검사
        for (int row = 0; row < 5; row++) {
            int rowCnt = 0;
            for (int col = 0; col < 5; col++) {
                if (bingo[row][col]) rowCnt++;
            }
            if (rowCnt == 5) cnt++;
        }

        // 열 검사
        for (int col = 0; col < 5; col++) {
            int colCnt = 0;
            for (int row = 0; row < 5; row++) {
                if (bingo[row][col]) colCnt++;
            }
            if (colCnt == 5) cnt++;
        }

        // ↘ 대각선 검사
        int diag1 = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i]) diag1++;
        }
        if (diag1 == 5) cnt++;

        // ↗ 대각선 검사
        int diag2 = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][4 - i]) diag2++;
        }
        if (diag2 == 5) cnt++;

        return cnt;
    }

}
