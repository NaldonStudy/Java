import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] map = new ArrayList[n+1];
        
        // 선언
        for(int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        
        // 채우기
        for(int[] thisEdge : edge) {
            map[thisEdge[0]].add(thisEdge[1]);
            map[thisEdge[1]].add(thisEdge[0]);
        }
        
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        dist[1] = 0;
        
        int maxDist = 0;
        
        while(!q.isEmpty()) {
            int nowNode = q.poll();
            
            for(int tempNode : map[nowNode]) {
                // 아직 방문안한곳만 가야함
                if(!visited[tempNode]) {
                    visited[tempNode] = true;
                    dist[tempNode] = dist[nowNode] + 1;
                    q.offer(tempNode);
                    
                    // 제일 먼곳 계산
                    maxDist = Math.max(maxDist, dist[tempNode]);
                }
            }
        }
        
        for(int d : dist) {
            if(d == maxDist) {
                answer++;
            }
        }
        return answer;
    }
}