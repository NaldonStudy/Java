import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Edge>[] adj;
	// 방문했을 때의 값을 기록할 배열
	static int[] minDist;
	
	static class Edge implements Comparable<Edge> {
		int to, cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer VE = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(VE.nextToken());
		E = Integer.parseInt(VE.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[V+1];
		for(int i = 0; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		
		minDist = new int[V+1];
		
		Arrays.fill(minDist, INF);
		
		for(int i = 0; i < E; i++) {
			StringTokenizer uvw = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(uvw.nextToken());
			int v = Integer.parseInt(uvw.nextToken());
			int w = Integer.parseInt(uvw.nextToken());
			
			adj[u].add(new Edge(v, w));
		}
		
		dijkstra(K);
		
		for(int i = 1; i <= V; i++) {
			if(minDist[i] == INF) {
				bw.write("INF");
			} else {
				bw.write("" + minDist[i]);
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	
	static void dijkstra(int start) {
		boolean[] visited = new boolean[V+1];
		
		minDist[start] = 0;
		
		for(int i = 0; i < V-1; i++) {
			int min = INF;
			
			int idx = -1;
			
			for(int j = 1; j <= V; j++) {
				if(!visited[j] && minDist[j] < min) {
					min = minDist[j];
					idx = j;
				}
			}
			
			if(idx == -1) break;
			
			visited[idx] = true;
			
			for(Edge e : adj[idx]) {
				if(!visited[e.to] && minDist[e.to] > minDist[idx] + e.cost) {
					minDist[e.to] = minDist[idx] + e.cost;
				}
			}
		}
	}
}
