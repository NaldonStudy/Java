class Solution {
    public int solution(int[][] triangle) {
        int answer = -1;
        int length = triangle.length;
        int[][] dp = new int[length][];
        dp[0] = new int[1];
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < length; i++) {
            dp[i] = new int[i+1];
            for(int j = 0; j < i; j++) {
                int tempLeft = dp[i-1][j] + triangle[i][j];
                dp[i][j] = Math.max(dp[i][j], tempLeft);
                int tempRight = dp[i-1][j] + triangle[i][j+1];
                dp[i][j+1] = Math.max(dp[i][j+1], tempRight);
            }
        }
        for(int val : dp[length-1]) {
            answer = Math.max(answer, val);   
        }
        return answer;
    }
}