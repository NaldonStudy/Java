import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }
        
        int[] res = new int[N];

        int index = K - 1;
        int cnt = 0;
        while(!list.isEmpty()) {
            if (index >= list.size()) {
                index %= list.size();
            }
            res[cnt++] = list.get(index);
            list.remove(index);
            index += K-1;
        }

        bw.write("<");
        for (int i = 0; i < N - 1; i++) {
            bw.write(res[i] + ", ");
        }
        bw.write(res[N - 1] + ">");
        bw.flush();
        bw.close();
    }
    
}