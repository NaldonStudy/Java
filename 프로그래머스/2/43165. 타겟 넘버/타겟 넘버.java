class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    public int dfs(int[] numbers, int target, int depth, int sum) {
        // depth가 끝이면 나와야지...
        if (depth == numbers.length) {
            // 정답이면 1 아니면 0
            if (sum == target) return 1;
            else return 0;
        }
        
        // 더한다면 ?
        int add = dfs(numbers, target, depth + 1, sum + numbers[depth]);        
        // 뺀다면 ?
        int sub = dfs(numbers, target, depth + 1, sum - numbers[depth]);

        // 이걸로 위로가면 지금까지 값들 누적
        return add + sub;
    }
}