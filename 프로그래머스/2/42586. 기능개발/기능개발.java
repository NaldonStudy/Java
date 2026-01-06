import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        int[] dayAfter = new int[len];
        for(int i = 0; i < len; i++) {
            dayAfter[i] = ((100-progresses[i]) / speeds[i]);
            if((100-progresses[i]) % speeds[i] != 0) dayAfter[i]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        int cnt = 1;
        int tempMax = dayAfter[0];
        for(int i = 1; i < len; i++) {
            // 지금 것보다 더 오래걸리는게 나오면 지금까지 쌓인건 한번에 출시
            if(tempMax < dayAfter[i]) {
                q.offer(cnt);
                cnt = 1;
                tempMax = dayAfter[i];
            }
            // 아니면 그냥 진행
            else cnt++;
            
            // 만약 맨 마지막이면 마지막 정산
            if(i == (len-1)) q.offer(cnt);
        }
        
        int[] answer = new int[q.size()];
        int idx = 0;
        while(!q.isEmpty()) {
            answer[idx++] = q.poll();
        }
        return answer;
    }
}