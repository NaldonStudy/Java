import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 힙은 PQ를 이용
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 모든 스코빌 지수를 힙에 삽입
        for (int s : scoville) {
            pq.add(s);
        }
        
        // 제일 작은값이 K보다 커질때까지
        while (pq.peek() < K) {
            // 음식이 하나만 남았는데 K보다 작음
            if (pq.size() < 2) {
                return -1;
            }
            
            int first = pq.poll();
            int second = pq.poll();
            int mixed = first + (second * 2);
            pq.add(mixed);
            
            answer++;
        }
        
        return answer;
    }
}