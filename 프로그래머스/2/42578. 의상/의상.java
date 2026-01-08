import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] nowCloth : clothes) {
            String category = nowCloth[1];
            // 지금 종류 가지고 있으면 value값 ++
            if(map.containsKey(category)) {
                int val = map.get(category) + 1;
                map.put(category, val);
            }
            // 안가지고 있으면 value = 1로 해서 생성
            else map.put(category, 1);
        }
        
        for(int value : map.values()) {
            answer *= (value+1);
        }
        return --answer;
    }
}