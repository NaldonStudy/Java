import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        // 중복을 피하려면 Set사용 <- 검색
        Set<Integer>[] dp = new HashSet[9]; 
        
        for (int i = 0; i <= 8; i++) {
            dp[i] = new HashSet<>();
        }

        // 처음값은 본인 하나겠지
        dp[1].add(N);

        for (int k = 2; k <= 8; k++) {
            Set<Integer> nowSet = dp[k]; 

            // 이어붙인 반복된 숫자
            int repeatNum = 0;
            for (int i = 0; i < k; i++) {
                repeatNum = repeatNum * 10 + N;
            }
            nowSet.add(repeatNum);

            // 조합짜보기
            for (int i = 1; i < k; i++) {
                Set<Integer> set1 = dp[i];
                Set<Integer> set2 = dp[k - i];

                for (int num1 : set1) {
                    for (int num2 : set2) {
                        nowSet.add(num1 + num2);
                        nowSet.add(num1 - num2);
                        nowSet.add(num1 * num2);
                        // 0은 나눌수가 없으니깐...
                        if (num2 != 0) {
                            nowSet.add(num1 / num2);
                        }
                    }
                }
            }
            // 정답을 찾으면 바로 반환
            if (nowSet.contains(number)) {
                return k;
            }
        }
        return -1;
    }
}