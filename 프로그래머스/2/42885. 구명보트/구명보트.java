import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int sp = 0;
        int ep = people.length - 1;
        
        while(sp <= ep) {
            // 최대 2명만 탈 수 있어서 조건걸기
            if (people[ep] + people[sp] <= limit) {
                sp++;
                ep--;
            } else {
                ep--;
            }
            answer++;
        }
        
        return answer;
    }
}