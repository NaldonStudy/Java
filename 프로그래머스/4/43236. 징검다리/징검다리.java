import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        long answer = 0;
        long left = 1;
        long right = distance;
        
        // 이분 탐색
        while (left <= right) {
            long mid = (left + right) / 2;
            
            int removeCnt = 0;
            int prev = 0;
            
            for (int rock : rocks) {
                // 현재 바위와 이전 위치 사이의 거리가 mid보다 작다면
                if (rock - prev < mid) {
                    removeCnt++;
                } else {
                    // 거리가 충분하면 현재 바위로 갱신
                    prev = rock;
                }
            }
            
            // 거리 체크
            if (distance - prev < mid) {
                removeCnt++;
            }
            
            if (removeCnt > n) {
                // 줄이기
                right = mid - 1;
            } else {
                // 더 큰 최솟값 찾기
                answer = mid;
                left = mid + 1;
            }
        }
        return (int) answer;
    }
}