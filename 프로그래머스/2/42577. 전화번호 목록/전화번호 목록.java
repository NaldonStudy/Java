import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> pBook = new HashMap<>();
        int len = phone_book.length;

        for (int i = 0; i < len; i++) {
            pBook.put(phone_book[i], i);
        }

        for (int i = 0; i < len; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                // 하나하나 잘라서 확인
                if (pBook.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}