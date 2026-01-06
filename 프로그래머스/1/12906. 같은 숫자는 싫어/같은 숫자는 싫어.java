import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        
        int before = arr[0];
        q.offer(before);
        for(int i = 1; i < arr.length; i++) {
            // 이전꺼랑 같으면 skip
            if(before == arr[i]) continue;
            // 아니면 queue에 담기
            q.offer(arr[i]);
            before = arr[i];
        }
        
        // queue에 담긴거 하나씩 정답에 담기
        int[] answer = new int[q.size()];
        int idx = 0;
        while(!q.isEmpty()) {
            answer[idx++] = q.poll();
        }

        return answer;
    }
}