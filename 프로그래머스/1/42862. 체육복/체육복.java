import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n];
        
        // 1벌이 기본
        Arrays.fill(students, 1);
        
        // 도난
        for (int l : lost) {
            students[l - 1]--;
        }
        
        // 여벌
        for (int r : reserve) {
            students[r - 1]++;
        }
        
        for (int i = 0; i < n; i++) {
            // 없으면
            if (students[i] == 0) {
                // 앞에사람 2개있나
                if (i - 1 >= 0 && students[i - 1] == 2) {
                    students[i]++;
                    students[i - 1]--;
                } 
                // 뒤에사람 2개있나
                else if (i + 1 < n && students[i + 1] == 2) {
                    students[i]++;
                    students[i + 1]--;
                }
            }
        }
        for (int s : students) {
            if (s >= 1) {
                answer++;
            }
        }
        return answer;
    }
}