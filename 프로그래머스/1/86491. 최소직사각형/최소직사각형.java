import java.lang.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int len = sizes.length;
        int maxSize = 0;
        int maxIdx = 0;
        int maxWH = 0;
        
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < 2; j++) {
                if(sizes[i][j] > maxSize) {
                    maxSize = sizes[i][j];
                    maxIdx = i;
                    maxWH = j;
                }
            }
        }

        int canLean = sizes[maxIdx][1-maxWH];
        
        loop:
        for(int i = 0; i < len; i++) {
            if(i == maxIdx) continue;
            int w = sizes[i][0];
            int h = sizes[i][1];
            int smaller = Math.min(w, h);
            canLean = Math.max(canLean, smaller);
        }
        
        answer = canLean * maxSize;
        
        return answer;
    }
}