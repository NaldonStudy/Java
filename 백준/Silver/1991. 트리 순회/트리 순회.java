import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
    static int[][] tree;
    static int N;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        tree = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer inTree = new StringTokenizer(br.readLine());
            int nowIdx = inTree.nextToken().charAt(0) - 'A';
            for(int j = 0; j < 2; j++) {
                char temp = inTree.nextToken().charAt(0);
                if(temp == '.') tree[nowIdx][j] = -1; // '.'을 -1로 처리 (없는 노드)
                else tree[nowIdx][j] = temp - 'A';
            }
        }

        sb = new StringBuilder();

        // 전위 순회 (Preorder)
        preorder(0);
        sb.append("\n");

        // 중위 순회 (Inorder)
        inorder(0);
        sb.append("\n");

        // 후위 순회 (Postorder)
        postorder(0);
        sb.append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    static void preorder(int idx) {
        if (idx == -1) return;
        sb.append((char)(idx + 'A'));
        preorder(tree[idx][0]);
        preorder(tree[idx][1]);
    }
    
    static void inorder(int idx) {
    	if(idx == -1) return;
        inorder(tree[idx][0]);
        sb.append((char)(idx + 'A'));
        inorder(tree[idx][1]);
    }
    
    static void postorder(int idx) {
    	if(idx == -1) return;
        postorder(tree[idx][0]);
        postorder(tree[idx][1]);
        sb.append((char)(idx + 'A'));
    }
}
