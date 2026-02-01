import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[21][21];

    // 우, 하, 우하, 우상
    static int[] dr = {0, 1, 1, -1};
    static int[] dc = {1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for (int i = 1; i <= 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 1; r <= 19; r++) {
            for (int c = 1; c <= 19; c++) {
                if (map[r][c] != 0) {
                    int curColor = map[r][c];

                    for (int d = 0; d < 4; d++) {
                        // 육목 방지
                        int prevR = r - dr[d];
                        int prevC = c - dc[d];

                        // 범위 내에 있고, 이전 돌 색이 현재와 같으면 중복탐색
                        if (isValid(prevR, prevC) && map[prevR][prevC] == curColor) {
                            continue;
                        }

                        // 연속 돌 카운트
                        int cnt = 1;
                        while (true) {
                            int nextR = r + dr[d] * cnt;
                            int nextC = c + dc[d] * cnt;

                            // 범위확인이나 다른색확인
                            if (!isValid(nextR, nextC) || map[nextR][nextC] != curColor) {
                                break;
                            }
                            cnt++;
                        }
                        
                        if (cnt == 5) {
                            bw.write(""+curColor);
                            bw.newLine();
                            bw.write(r + " " + c);

                            bw.flush();
                            bw.close();
                            return;
                        }
                    }
                }
            }
        }

        // 승부가 나지 않았을 때
        bw.write("0");
        bw.flush();
        bw.close();
        br.close();
    }

    // 배열 범위 체크 유틸리티 메서드
    static boolean isValid(int r, int c) {
        return r >= 1 && r <= 19 && c >= 1 && c <= 19;
    }
}