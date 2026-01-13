import java.util.*;

class Solution {
    class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        // 오름차순
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    List<Node>[] list;
    boolean[] visited;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        list = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int[] cost : costs) {
            int start = cost[0];
            int end = cost[1];
            int c = cost[2];
            
            list[start].add(new Node(end, c));
            list[end].add(new Node(start, c));
        }

        visited = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            // 이미 방문했으면 continue
            if(visited[current.to]) continue;

            // 방문 안 한 곳이면 무조건 가고 방문 처리
            visited[current.to] = true;
            answer += current.cost;

            // 연결된섬
            for(Node next : list[current.to]) {
                if(!visited[next.to]) {
                    pq.offer(next);
                }
            }
        }

        return answer;
    }
}