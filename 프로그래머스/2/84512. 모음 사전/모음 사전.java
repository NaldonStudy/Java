import java.util.*;

class Solution {
    List<String> dictionary = new ArrayList<>();
    String[] vowels = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        generate("");
        int answer = dictionary.indexOf(word) + 1;
        return answer;
    }

    // 단어 만들기
    public void generate(String currentWord) {
        // 탈출. 길이 5 유지
        if (currentWord.length() > 5) return;
        
        // 빈건 빼고 추가
        if (!currentWord.equals("")) {
            dictionary.add(currentWord);
        }

        for (int i = 0; i < 5; i++) {
            generate(currentWord + vowels[i]);
        }
    }
}