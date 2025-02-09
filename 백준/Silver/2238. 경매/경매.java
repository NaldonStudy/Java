import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int U = Integer.parseInt(st.nextToken()); // 최대 입찰 가격
        int N = Integer.parseInt(st.nextToken()); // 참가자 수

        int[] priceCnt = new int[U + 1]; // 가격별 등장 횟수 저장 배열
        String[] name = new String[N];   // 참가자 이름 저장 배열
        int[] price = new int[N];        // 참가자 입찰 가격 저장 배열

        for (int i = 0; i < N; i++) {
            StringTokenizer np = new StringTokenizer(br.readLine());
            name[i] = np.nextToken();
            price[i] = Integer.parseInt(np.nextToken());
            priceCnt[price[i]]++; // 가격 등장 횟수 증가
        }

        // 1. 가장 적게 등장한 가격 찾기
        int minCount = Integer.MAX_VALUE;
        int minPrice = -1;

        for (int i = 1; i <= U; i++) { // 가격 범위 내에서 확인
            if (priceCnt[i] > 0 && priceCnt[i] < minCount) { 
                minCount = priceCnt[i]; 
                minPrice = i; 
            }
        }

        // 2. 최소 등장 가격을 가진 첫 번째 사람 찾기
        for (int i = 0; i < N; i++) {
            if (price[i] == minPrice) {
                bw.write(name[i] + " " + price[i]); 
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}
