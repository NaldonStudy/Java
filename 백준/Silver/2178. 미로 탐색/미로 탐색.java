import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    // 상 하 좌 우
    static int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    
    static int bfs (int[][] map, int[] end) {
        Queue<int[]> queue = new LinkedList<>();    // 큐에 적으면서, 큐와 같이 동작하기
        
        queue.offer(new int[]{0,0});    // 시작지점은 정해져있고, 비어있다면 다음 코드가 작동을 하지 않을거기 때문에 이런게 필요
        
        while(!queue.isEmpty()) {
            int[] nowSpot = queue.poll();
            int r = nowSpot[0];
            int c = nowSpot[1];
            
            for (int[] dir : dirs) {
                int nr = r + dir[0];	// 내가 살펴볼 row좌표
                int nc = c + dir[1];	// 내가 살펴볼 col좌표
                if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length)     // 범위 밖으로 나간다면?
                    continue;        // 범위 밖은 그냥 다른 부분을 찾아보자
                if (map[nr][nc] == 0 || map[nr][nc] != 1)         // 만약 이동할수 없는 칸이라면? (벽이라던가, 이미 다녀왔던가)
                    continue;        // 다른 부분을 또 살펴보자
                map[nr][nc] = map[r][c] + 1;        // 내가 방문한 곳 이라면 + 1을 해주면서 그 길까지의 최솟값을 기록한다.
                
                queue.add(new int[]{nr, nc});        // 내가 살펴본 곳 중 갈 수 있는 곳이라면 큐에 추가 (내가 갈거야)
            }
        }
        return map[end[0]][end[1]]; 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer NM = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(NM.nextToken());
        int M = Integer.parseInt(NM.nextToken());
        
        int[][] mirroMap = new int[N][M];
        
        for(int row = 0; row < N; row++) {
            String inMap = br.readLine();
            for (int col = 0; col < M; col++) {
                char temp = inMap.charAt(col);
                mirroMap[row][col] = temp - '0';
            }
        }
        
        int[] end = {N-1, M-1};
        int res = bfs(mirroMap, end);
        bw.write(Integer.toString(res));
        bw.flush();
        bw.close();
    }
}