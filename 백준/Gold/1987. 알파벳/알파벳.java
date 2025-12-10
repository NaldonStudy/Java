import java.io.*;
import java.util.*;

public class Main {

    static char[][] map;
    static boolean[] alphabet;

    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int R, C, maxDepth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer RC = new StringTokenizer(br.readLine());
        R = Integer.parseInt(RC.nextToken());
        C = Integer.parseInt(RC.nextToken());

        map = new char[R][C];
        alphabet = new boolean[26];

        for(int r = 0; r < R; r++) {
            String rowVal = br.readLine();
            map[r] = rowVal.toCharArray();
        }

        // 시작점 (0,0) 미리 처리
        int startAlpha = map[0][0] - 65;
        alphabet[startAlpha] = true;
        maxDepth = 1;

        dfs(0, 0, 1);

        bw.write(""+maxDepth);
        bw.flush();
        bw.close();
    }

    static void dfs (int r, int c, int depth) {
        // 그 깊이를 확인해보기
        if(depth > maxDepth) {
            maxDepth = depth;
        }

        // 이제부터 백트레킹
        for(int d = 0; d < 4; d++) {
            // 다음 위치
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 일단 다음 위치가 범위 이내인지 확인
            if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

            // 알파벳은 괜찮나 ?
            int nextAplpha = (int)map[nr][nc] - 65;
            if(alphabet[nextAplpha]) continue;

            // 이 조건들 아니면 보내자
            alphabet[nextAplpha] = true;
            dfs(nr, nc, depth+1);
            alphabet[nextAplpha] = false;
        }
    }
}