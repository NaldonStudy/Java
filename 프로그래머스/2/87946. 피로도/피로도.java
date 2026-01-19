import java.util.*;

class Solution {
    static int lenDungeons;
    static int[][] globalDungeons;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        lenDungeons = dungeons.length;
        globalDungeons = dungeons;
        boolean[] visited = new boolean[lenDungeons];
        
        answer = findBest(k, 0, visited);
        
        return answer;
    }
    
    
    static int findBest(int k, int depth, boolean[] visited) {
        int maxDepth = depth;
        for(int i = 0; i < lenDungeons; i++) {
            // 1. 방문했으면 안가
            if(visited[i]) continue;
            // 2. 최소피로도가 지금 피로도보다 작으면 안가
            if(globalDungeons[i][0] > k) continue;
            
            // 안갔으면 방문처리 하고 들어가기
            visited[i] = true;
            int temp = findBest(k-globalDungeons[i][1], depth+1, visited);
            maxDepth = Math.max(maxDepth, temp);
            visited[i] = false;
        }
        return maxDepth;
    }
}