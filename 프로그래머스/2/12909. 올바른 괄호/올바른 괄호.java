import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else count--;

            // 닫는 괄호가 더 많이 나오면 안된다
            if (count < 0) {
                return false;
            }
        }

        if(count == 0) answer = true;
        return answer;
    }
}