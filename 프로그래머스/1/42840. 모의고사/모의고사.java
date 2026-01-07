import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 패턴
        int[] pOne = {1, 2, 3, 4, 5};
        int[] pTwo = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pThree = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int sOne = 0;
        int sTwo = 0;
        int sThree = 0;
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == pOne[i % pOne.length]) sOne++;
            if(answers[i] == pTwo[i % pTwo.length]) sTwo++;
            if(answers[i] == pThree[i % pThree.length]) sThree++;
        }
        
        // 가장 높은 점수
        int maxScore = Math.max(sOne, Math.max(sTwo, sThree));
        
        // 오름차순
        Queue<Integer> scoreQ = new LinkedList<>();
        if(maxScore == sOne) scoreQ.add(1);
        if(maxScore == sTwo) scoreQ.add(2);
        if(maxScore == sThree) scoreQ.add(3);
        
        int[] ans = new int[scoreQ.size()];
        int idx = 0;
        while(!scoreQ.isEmpty()) {
            ans[idx++] = scoreQ.poll();
        }

        return ans;
    }
}