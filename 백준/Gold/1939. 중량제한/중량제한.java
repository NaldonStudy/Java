import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int N, start, end;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxWeight = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
            maxWeight = Math.max(maxWeight, C);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = maxWeight;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (bfs(mid)) {
                result = mid;      
                left = mid + 1;
            } else {
                right = mid - 1;   
            }
        }

        bw.write(""+result);
		bw.flush();
		bw.close();
    }

    static boolean bfs(int weight) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == end) return true;

            for (Node next : graph[now]) {
                if (!visited[next.to] && next.weight >= weight) {
                    visited[next.to] = true;
                    queue.add(next.to);
                }
            }
        }

        return false;
    }
}
