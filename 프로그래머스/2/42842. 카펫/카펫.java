class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        for(int height = 3; height * height <= total; height++) {
            if(total % height != 0) continue;
            
            int width = total / height;
            if((width-2) * (height-2) != yellow) continue;
            
            int[] answer = {width, height};
            return answer;
        }
        return null;
    }
}