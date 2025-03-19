import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] arr; // 중위 순회 결과 배열
    static ArrayList<Integer>[] levels; // 각 레벨별 노드를 저장할 리스트 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int K = Integer.parseInt(br.readLine());
        int n = (int) Math.pow(2, K) - 1; // 전체 노드 개수
        
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 각 레벨마다 ArrayList를 초기화
        levels = new ArrayList[K];
        for(int i = 0; i < K; i++){
            levels[i] = new ArrayList<>();
        }
        
        // 재귀 함수 호출: 전체 구간 [0, n-1]에서 시작, 레벨 0부터 시작
        inorder(0, n - 1, 0);
        
        // 각 레벨의 노드를 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < K; i++){
            for(int num : levels[i]){
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        
        bw.write(sb+"");
        bw.flush();
        bw.close();
    }
    
    // 재귀적으로 중간값(루트)을 찾아 각 레벨에 저장하는 함수
    static void inorder(int start, int end, int level){
        if(start > end) return;
        int mid = (start + end) / 2;
        levels[level].add(arr[mid]);
        inorder(start, mid - 1, level + 1);  // 왼쪽 서브트리
        inorder(mid + 1, end, level + 1);    // 오른쪽 서브트리
    }
}