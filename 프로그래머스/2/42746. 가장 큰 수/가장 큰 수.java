import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] numStr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            numStr[i] = "" + numbers[i];
        }
        
        Arrays.sort(numStr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        // 다 0이면
        if (numStr[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : numStr) {
            sb.append(s);
        }
        
        return answer + sb;
    }
}