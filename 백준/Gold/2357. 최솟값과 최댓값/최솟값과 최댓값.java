import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] minTree;
    static int[] maxTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer NM = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(NM.nextToken());
        int M = Integer.parseInt(NM.nextToken());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        minTree = new int[N * 4];
        maxTree = new int[N * 4];

        initMin(1, 1, N);
        initMax(1, 1, N);

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int minVal = findMin(1, 1, N, a, b);
            int maxVal = findMax(1, 1, N, a, b);

            bw.write(minVal + " " + maxVal);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    // 최솟값 트리
    static int initMin(int node, int start, int end) {
        if (start == end) {
            return minTree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return minTree[node] = Math.min(initMin(node * 2, start, mid), initMin(node * 2 + 1, mid + 1, end));
    }

    // 최댓값 트리
    static int initMax(int node, int start, int end) {
        if (start == end) {
            return maxTree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return maxTree[node] = Math.max(initMax(node * 2, start, mid), initMax(node * 2 + 1, mid + 1, end));
    }

    // 최솟값 찾기
    static int findMin(int node, int start, int end, int left, int right) {
        // MathMin에 관여 못하게. 내가 알빠 아닌 구간임
        if (left > end || right < start) {
            return Integer.MAX_VALUE;
        }
        // 이건 내 범위 안에 들어있으니깐 그냥 이부분 반환
        if (left <= start && end <= right) {
            return minTree[node];
        }
        int mid = (start + end) / 2;
        return Math.min(findMin(node * 2, start, mid, left, right), findMin(node * 2 + 1, mid + 1, end, left, right));
    }

    // 최댓값 찾기
    static int findMax(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Integer.MIN_VALUE;
        }
        if (left <= start && end <= right) {
            return maxTree[node];
        }
        int mid = (start + end) / 2;
        return Math.max(findMax(node * 2, start, mid, left, right), findMax(node * 2 + 1, mid + 1, end, left, right));
    }
}