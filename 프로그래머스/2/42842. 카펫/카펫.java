class Solution {
    public int[] solution(int brown, int yellow) {
        // 전체넓이
        int totalArea = brown + yellow;

        // 세로길이 + 3반복
        // 세로 <= 가로 유지
        for (int height = 3; height * height <= totalArea; height++) {
            
            // 전체 넓이가 세로 길이로 나누어떨어져야 사각형이 됨
            if (totalArea % height == 0) {
                int width = totalArea / height;

                // 격자 수 일치
                if ((width - 2) * (height - 2) == yellow) {
                    return new int[] {width, height};
                }
            }
        }
        return null;
    }
}