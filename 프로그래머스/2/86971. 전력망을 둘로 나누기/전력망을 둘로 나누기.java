import java.util.*;

class Solution {
    static ArrayList<Integer>[] map;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        map = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            map[v1].add(v2);
            map[v2].add(v1);
        }

        // 하나씩 끊으며 확인
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            // 걍 v1만 구해도 댐
            int count = bfs(v1, v2, n);

            int temp = Math.abs(count - (n - count));
            answer = Math.min(answer, temp);
        }

        return answer;
    }

    public int bfs(int startNode, int ignoreNode, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        
        q.offer(startNode);
        visited[startNode] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int nowPlace = q.poll();

            for (int next : map[nowPlace]) {
                // 끊어진쪽은 안감. 방문했었어도 안감.
                if (next == ignoreNode || visited[next]) continue;

                visited[next] = true;
                q.offer(next);
                cnt++;
            }
        }
        return cnt;
    }
}