import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    // 방문 처리: 해당 지점에 도착했을 때 남은 힘을 저장 (더 큰 힘으로 오면 갱신)
    static int[][] visited;

    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int H, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer HWOFXsYsXeYe = new StringTokenizer(br.readLine());
            H = Integer.parseInt(HWOFXsYsXeYe.nextToken());
            W = Integer.parseInt(HWOFXsYsXeYe.nextToken());
            int O = Integer.parseInt(HWOFXsYsXeYe.nextToken());
            int F = Integer.parseInt(HWOFXsYsXeYe.nextToken());

            // 좌표는 1부터 시작하므로 -1 해주기
            int Xs = Integer.parseInt(HWOFXsYsXeYe.nextToken()) - 1;
            int Ys = Integer.parseInt(HWOFXsYsXeYe.nextToken()) - 1;
            int Xe = Integer.parseInt(HWOFXsYsXeYe.nextToken()) - 1;
            int Ye = Integer.parseInt(HWOFXsYsXeYe.nextToken()) - 1;

            map = new int[H][W];
            visited = new int[H][W];

            // visited 배열 초기화. 아직 방문 안 한건 -1
            for(int i=0; i<H; i++) Arrays.fill(visited[i], -1);

            for (int oc = 0; oc < O; oc++) {
                StringTokenizer object = new StringTokenizer(br.readLine());
                // 장애물 좌표도 -1
                int r = Integer.parseInt(object.nextToken()) - 1;
                int c = Integer.parseInt(object.nextToken()) - 1;
                int l = Integer.parseInt(object.nextToken());
                map[r][c] = l;
            }

            if (bfs(F, Xs, Ys, Xe, Ye)) {
                bw.write("잘했어!!\n");
            } else {
                bw.write("인성 문제있어??\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static boolean bfs(int F, int Xs, int Ys, int Xe, int Ye) {
        Queue<int[]> q = new LinkedList<>();
        // x, y, 남은 힘
        q.offer(new int[]{Xs, Ys, F});
        // 시작점 방문 처리
        visited[Xs][Ys] = F;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int curX = now[0];
            int curY = now[1];
            int curF = now[2];

            // 목적지 도착 확인
            if (curX == Xe && curY == Ye) return true;

            // 남은 힘이 0이면 이동 불가
            // 도착하면서 힘이 0이 되는 건 성공이여서 도착지점 체크가 먼저
            if (curF <= 0) continue;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dr[i];
                int nextY = curY + dc[i];

                // 1. 맵 범위 체크
                if (nextX < 0 || nextY < 0 || nextX >= H || nextY >= W) continue;

                // 이동 시 소모되는 힘
                int nextF = curF - 1;

                // 2. 높이 비교
                int heightDiff = map[nextX][nextY] - map[curX][curY];

                // 오르막길
                if (heightDiff > 0) { 
                    // 현재 남은 힘보다 높이 차이가 크면 못 감
                    if (heightDiff > curF) continue;
                }

                // 3. 방문 처리
                // 이미 방문한 곳인데, 지금 내가 가진 힘F가 기존에 기록된 F보다 작거나 같으면 굳이 갈 필요 없음
                if (visited[nextX][nextY] >= nextF) continue;

                // 방문 갱신 및 큐 삽입
                visited[nextX][nextY] = nextF;
                q.offer(new int[]{nextX, nextY, nextF});
            }
        }
        return false;
    }
}