import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> idxStack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++) {
            // 스택이 비어있지 않음 && 현재 가격이 스택 맨 위 가격보다 떨어짐
            while(!idxStack.isEmpty() && prices[idxStack.peek()] > prices[i]) {
                int index = idxStack.pop();
                answer[index] = i - index;
            }
            // 현재 시점은 무조건 넣기
            idxStack.push(i);
        }
        
        // 마지막 정리
        while(!idxStack.isEmpty()) {
            int index = idxStack.pop();
            // 이게 딱 차이임.
            answer[index] = (prices.length - 1) - index;
        }
        return answer;
    }
}