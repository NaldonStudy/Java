class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        // 숫자를 char로 변환해서 찾기
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            
            // sb에 숫자가 있을 때, sb에서 마지막 숫자가 지금것보다 작거나, 더 제거해도 괜찮으면 갈아끼우기
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) < c && k > 0) {
                // 이거 처음앎... deleteCharAt 기억하기
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            
            // sb에 담기
            sb.append(c);
        }
        
        // 계속 작아질수도 있어서, 남으면 뒤에를 자르기
        return sb.substring(0, sb.length() - k);
    }
}