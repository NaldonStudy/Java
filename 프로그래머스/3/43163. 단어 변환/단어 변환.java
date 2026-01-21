import java.util.*;

class Solution {
    static class Node {
        String word;
        int count;
        
        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        // words에 없으면 애초에 못감
        boolean containsTarget = false;
        for (String w : words) {
            if (w.equals(target)) {
                containsTarget = true;
                break;
            }
        }
        if (!containsTarget) return 0;

        // BFS
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(begin, 0));
        
        boolean[] visited = new boolean[words.length];
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            // 탈출
            if (current.word.equals(target)) {
                return current.count;
            }
            
            // 다음단계로 갈 수 있는지
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && diffOnlyOne(current.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], current.count + 1));
                }
            }
        }
        return 0;
    }
    
    // 글자 하나만 다른지 확인
    private boolean diffOnlyOne(String w1, String w2) {
        int diffCount = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }
}