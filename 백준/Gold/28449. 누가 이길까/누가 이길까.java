import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer NM = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(NM.nextToken());
        int M = Integer.parseInt(NM.nextToken());

        int[] HI_power = new int[N];
        int[] ARC_power = new int[M];

        StringTokenizer HI_coding = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            HI_power[i] = Integer.parseInt(HI_coding.nextToken());
        }

        StringTokenizer ARC_coding = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            ARC_power[i] = Integer.parseInt(ARC_coding.nextToken());
        }

        Arrays.sort(HI_power);
        Arrays.sort(ARC_power);

        long HI_Win = 0;
        long ARC_Win = 0;
        long draw = 0;

        for(int hi : HI_power) {
            // 2가지 케이스의 이유는 무승부 때문이다. 무승부 범위를 알아야 그 위아래로 승 패를 구분할 수 있다.
            // ARC_power 배열에서 hi보다 크거나 같은 첫번째 위치 (아래쪽 확인)
            int lb = lowerBound(M, ARC_power, hi);
            // ARC_power 배열에서 hi보다 큰 첫번째 위치 (위쪽 확인)
            int ub = upperBound(M, ARC_power, hi);

            HI_Win += lb;               // lb아래로는 HI가 이김
            ARC_Win += (M - ub);        // ub위로는 ARC가 이김
            draw += (ub - lb);          // ub-lb가 비긴 갯수임
        }

        bw.write(HI_Win + " " + ARC_Win + " " + draw);
        bw.flush();
        bw.close();
    }

    // target보다 크거나 같은 값이 처음
    private static int lowerBound(int length, int[] arr, int target) {
        int left = 0;
        int right = length;

        while (left < right) {
            int mid = (left + right) / 2;
            if(arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // target보다 큰 값이 처음. 무승부 때문에 2가지 방법으로 나눠야함
    private static int upperBound(int length, int[] arr, int target) {
        int left = 0;
        int right = length;

        while (left < right) {
            int mid = (left + right) / 2;
            if(arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
