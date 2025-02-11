import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        Set<Integer> nSet = new HashSet<>();
        
        StringTokenizer nInput = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nSet.add(Integer.parseInt(nInput.nextToken()));
        }
        
        int M = Integer.parseInt(br.readLine());
        
        StringTokenizer mInput = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(mInput.nextToken());
            if (nSet.contains(num)) { // contains는 true,false를 반환한다. indexof처럼 위치반환안함
                bw.write(1 + "\n");
            } else {
                bw.write(0 + "\n");
            }
        }
        
        bw.flush();
        bw.close();
    }
}
