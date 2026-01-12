import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String operation : operations) {
            String[] nowOperation = operation.split(" ");
            int num = Integer.parseInt(nowOperation[1]);
        
            // I면 삽입
            if(nowOperation[0].equals("I")) {
                minPq.offer(num);
                maxPq.offer(num);
            }
            // D면 삭제
            else {
                // 근데 길이보다 길면... 무시하래
                if(minPq.isEmpty()) continue;
                // 근데 안길면 어떤 작업 할건지 정해야지
                // 1이면 최댓값을 삭제
                if(num == 1) {
                    int maxNum = maxPq.poll();
                    minPq.remove(maxNum);
                }
                // -1이면 최솟값을 삭제
                else {
                    int minNum = minPq.poll();
                    maxPq.remove(minNum);
                }
            }
        }
        // 끝났을때 비어있으면
        if(minPq.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = maxPq.poll();
            answer[1] = minPq.poll();
        }
        
        return answer;
    }
}