import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	// 동쪽 남쪽
	static int[] dr = {0, 1};
	static int[] dc = {1, 0};
	
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer NM = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(NM.nextToken());
		int M = Integer.parseInt(NM.nextToken());
		
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for(int r = 0; r < M; r++) {
			StringTokenizer inRow = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(inRow.nextToken());
			}
		}
		int[] end = {M, N};
		boolean res = bfs(end);
		
		if(res) {
			bw.write("Yes");
		} else {
			bw.write("No");
		}
		bw.flush();
		bw.close();
	}
	
	static boolean bfs(int[] end) {
		int endR = end[0] - 1;
		int endC = end[1] - 1;
		
		Queue<int[]> q = new LinkedList<>();
		int[] start = {0,0};
		
		q.add(start);
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			if(now[0] == endR && now[1] == endC)
				return true;
			
			for(int d = 0; d < 2; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				
				// 범위밖
				if(nr > endR || nc > endC) continue;
				
				// 방문했다면
				if(visited[nr][nc]) continue;
				
				// 가는곳 정보가 0
				if(map[nr][nc] == 0) continue;
				
				int[] next = {nr, nc};
				visited[nr][nc] = true;
				q.add(next);
			}
		}
		
		return false;
	}
}
