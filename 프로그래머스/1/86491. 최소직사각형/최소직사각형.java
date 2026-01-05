import java.lang.*;

class Solution {
    public int solution(int[][] sizes) {
        int widthMax = 0;
        int heightMax = 0;
        for(int[] card : sizes) {
            widthMax = Math.max(widthMax, Math.max(card[0], card[1]));
            heightMax = Math.max(heightMax, Math.min(card[0], card[1]));
        }
        int answer = widthMax * heightMax;
        return answer;
    }
}