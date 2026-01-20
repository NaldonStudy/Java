import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int truckCount = truck_weights.length;
        int weightSum = 0;
        Queue<Integer> q = new LinkedList<>();
        int frontTruckIdx = 0;
        int nextTruckIdx = 0;
        
        while(nextTruckIdx < truckCount) {
            answer++;
            // 시간 다 되신분은 나오실게요
            if(!q.isEmpty() && ((answer - q.peek()) == bridge_length)) {
                weightSum -= truck_weights[frontTruckIdx++];
                q.poll();
            }
            
            // 일단 최대 갯수 넘으면 못타세요 ㅇㅇ
            if(q.size() >= bridge_length) continue;
            // 총 무게 합도 기준보다 크시면 못타세요 ㅇㅇ
            if(weightSum + truck_weights[nextTruckIdx] > weight) continue;
            
            // 아니면 올라 타실 수 있으심
            q.offer(answer);
            weightSum += truck_weights[nextTruckIdx++];
        }
        
        return answer + bridge_length;
    }
}