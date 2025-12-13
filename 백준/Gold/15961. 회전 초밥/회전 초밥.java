import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushiTable = new int[N];
        // 각 초밥 종류별 먹은 개수 카운팅
        // 초밥 종류 번호 그대로 인덱스 사용
        int[] visited = new int[d + 1];

        for(int i = 0; i < N; i++) {
            sushiTable[i] = Integer.parseInt(br.readLine());
        }

        // 현재 윈도우 내의 초밥 가짓수
        int count = 0;

        // 1. 초기 윈도우설정
        for(int i = 0; i < k; i++) {
            if(visited[sushiTable[i]] == 0) {
                count++;
            }
            visited[sushiTable[i]]++;
        }

        int maxCount = count;
        // 쿠폰 초밥이 현재 윈도우에 없다면 가짓수 +1
        if (visited[c] == 0) maxCount++;

        // 2. 슬라이딩 윈도우
        // i는 제거될 접시의 인덱스. 0부터 시작해서 한 칸씩 밈
        for(int i = 0; i < N; i++) {
            // 맨 앞 접시 제거 i
            int removeDish = sushiTable[i];
            visited[removeDish]--;
            if(visited[removeDish] == 0) {
                count--;
            }

            // 새 접시 추가 i + k -> 회전 고려해서 % N
            int addDish = sushiTable[(i + k) % N];
            if(visited[addDish] == 0) {
                count++;
            }
            visited[addDish]++;

            // 최댓값 계산. 쿠폰 고려
            int currentTotal = count;
            if(visited[c] == 0) {
                currentTotal++;
            }

            maxCount = Math.max(maxCount, currentTotal);
        }
        bw.write(""+maxCount);
        bw.flush();
        bw.close();
    }
}