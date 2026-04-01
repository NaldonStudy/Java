import java.io.*;
import java.util.*;

public class Main {
    final static int diff_Num = 1000;
    public static int N;
    // 기본 배열 담기. A
    public static int[][] default_Matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        default_Matrix = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {

                // 초기 행렬도 % 1,000 해야함
                default_Matrix[i][j] = Integer.parseInt(st.nextToken()) % diff_Num;
            }
        }
        int[][] result = pow(default_Matrix, B);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }


    public static int[][] pow(int[][] A, long exp) {
        // 지수가 1일 땐 A를 return
        if(exp == 1L) {
            return A;
        }

        // 지수를 절반으로 분할하여 재귀호출
        int[][] ret = pow(A, exp / 2);

        // 하위 재귀에서 얻은 행렬을 제곱
        ret = multiply(ret, ret);

        // 만약 지수가 홀수라면 마지막에  A 행렬을 곱해준다.
        if(exp % 2 == 1L) {
            ret = multiply(ret, default_Matrix);
        }
        return ret;
    }


    // o1과 o2 행렬을 곱해주는 메소드
    public static int[][] multiply(int[][] o1, int[][] o2) {
        int[][] ret = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {

                    ret[i][j] += o1[i][k] * o2[k][j];
                    // 행렬 원소 연산이 끝나면 diff_Num로 나머지연산
                    ret[i][j] %= diff_Num;
                }
            }
        }
        return ret;
    }
}