import java.util.*;

class Disk implements Comparable<Disk> {
    int id;
    int start;
    int spend;
    
    Disk(int id, int start, int spend) {
        this.id = id;
        this.start = start;
        this.spend = spend;
    }
    
    @Override
    public int compareTo(Disk o) {
        if(this.spend != o.spend) {
            return this.spend - o.spend;
        }
        if(this.start != o.start) {
            return this.start - o.start;
        }
        return this.id - o.id;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Disk> pq = new PriorityQueue<>();
        
        int idx = 0;
        int end = 0;
        int answer = 0;
        int count = 0;
        
        while(count < jobs.length) {
            
            // 지금 시간대에 것들은 다 넣음
            while(idx < jobs.length && jobs[idx][0] <= end) {
                pq.add(new Disk(idx, jobs[idx][0], jobs[idx++][1]));
            }
            
            // 비어있으면 다음작업하기
            if(pq.isEmpty()) {
                end = jobs[idx][0];
            } 
            // 안비어있으면 일함
            else {
                Disk temp = pq.poll();
                
                end += temp.spend;
                answer += end - temp.start;
                
                count++;
            }
        }
        return answer / jobs.length;
    }
}