import java.util.*;

class Solution {
    int length;
    boolean[] counted;
    boolean[] primeNum;
    int answer;
    int[] nums;

    public int solution(String numbers) {
        answer = 0;
        char[] charNums = numbers.toCharArray();
        length = numbers.length();
        
        int maxNum = (int) Math.pow(10, length);
        counted = new boolean[maxNum];
        
        // 에라토스테네스의 체. 소수면 false
        primeNum = new boolean[maxNum];
        primeNum[0] = true;
        primeNum[1] = true;
        for(int i = 2; i * i < primeNum.length; i++) {
            if(!primeNum[i]) {
                for(int j = i*i; j < primeNum.length; j+=i) {
                    primeNum[j] = true;
                }
            }
        }
                
        // 숫자변환
        nums = new int[length];
        for(int i = 0; i < length; i++) {
            nums[i] = (int)charNums[i] - '0';
        }
        
        boolean[] visited = new boolean[length];
        findCase(visited, 0, 0);
        
        return answer;
    }
    
    void findCase(boolean[] visited, int num, int depth) {
        // 지금 숫자 확인부터
        if(num > 0 && !counted[num]) {
            counted[num] = true;
            if(!primeNum[num]) {
                answer++;
            }
        }

        // 종료조건
        if(depth == length) {
            return;
        }
        
        for(int i = 0; i < length; i++) {
            // 이미 방문했으면
            if(visited[i]) continue;
            
            // 방문 처리
            visited[i] = true;
            findCase(visited, num * 10 + nums[i], depth + 1);
            visited[i] = false;
        }
    } 
}