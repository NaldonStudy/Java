import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer NM = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(NM.nextToken());
        int M = Integer.parseInt(NM.nextToken());

        int[] indegree = new int[N + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer ab = new StringTokenizer(br.readLine());
            // 먼저 풀어야 하는 문제
            int a = Integer.parseInt(ab.nextToken());
            // 나중에 풀어야 하는 문제
            int b = Integer.parseInt(ab.nextToken());

            graph.get(a).add(b);
            // b문제의 진입 차수 증가. 이래야 뒤로 밀림.
            indegree[b]++;
        }

        // 문제 번호 작은 것 우선으로해야하니깐 pq로 해야함.
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 1. 먼저 들을거 없는, 진입차수가 0인 문제들 삽입
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }

        // 2. 위상정렬 이용해서 큐가 빌 때까지 반복
        while (!pq.isEmpty()) {
            // 현재 풀 수 있는 문제 중 가장 번호가 작은 문제
            int current = pq.poll(); 
            bw.write(current + " ");

            // 현재 문제와 연결된 다음 문제들의 진입 차수 감소
            for (int next : graph.get(current)) {
                indegree[next]--;

                // 줄인다음에 진입차수가 0이 되면 삽입. 그땐 이미 들어야하는거 다 들은거니깐은
                if (indegree[next] == 0) {
                    pq.offer(next);
                }
            }
        }
        bw.flush();
        bw.close();
    }
}