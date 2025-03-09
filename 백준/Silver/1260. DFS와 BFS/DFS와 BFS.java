import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] tree;
	static boolean[] visit;
	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        
        
        StringTokenizer NMV = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(NMV.nextToken());
        int M = Integer.parseInt(NMV.nextToken());
        int V = Integer.parseInt(NMV.nextToken());

        tree = new int[N+1][N+1];
        
        for(int i = 0; i < M; i++) {
        	StringTokenizer ab = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(ab.nextToken());
            int b = Integer.parseInt(ab.nextToken());

            tree[a][b] = 1;
            tree[b][a] = 1;
            // 입력으로 주어지는 간선은 양방향이므로 둘 다 체크해준다.
        }
        
        visit = new boolean[N+1];
        dfs(V);
        bw.newLine();
        bw.flush();
        visit = new boolean[N+1];
        bfs(V);
        bw.flush();
        bw.close();
    }
    
    static void dfs(int V) throws IOException {
        visit[V] = true; // V: 탐색을 시작할 정점의 번호 -> 해당 번호는 이미 방문한 정점이므로 방문했다는 표식을 남겨줌
        bw.write(V + " ");
        
        if(V > N) {	// N보다 큰건 존재할 수 없음
           return;
        }
        
        for(int node = 1; node < tree.length; node++) { // j: 정점 번호 -> 정점의 1 ~ 끝 번호까지 반복문을 돌림
            // arr[V][node] == 1: 연결된 두 정점이다 / visited[j] == false: 아직 방문하지 않았다
            if(tree[V][node] == 1 && visit[node] == false) {
                dfs(node); // -> 다시 dfs(j) 함수를 호출해줌(재귀함수) -> 호출하면 이제 방문했다는 표식을 남길 수 있음
            }
        }
    }
    
    static void bfs(int V) throws IOException {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(V); // 큐에 해당 정점 번호를 넣어줌
        visit[V] = true; // 방문했다는 표식을 남겨줌
        bw.write(V + " ");

        while(!queue.isEmpty()) { // 큐가 비어있지 않으면
            int temp = queue.poll(); // 큐에 담겨있는 번호 중 가장 앞에 담겨져있는 번호
            for(int node = 1; node < tree.length; node++) {
                if(tree[temp][node] == 1 && visit[node] == false) { // 해당 노드와 연결된 다른 노드가 있고 그 다른 노드를 아직 방문하지 않았다면
                    queue.add(node); // 다른 노드를 queue에 넣고
                    visit[node] = true; // 방문했다는 표식을 남겨줌
                    bw.write(node + " ");
                }
            }
        }
    }    
}