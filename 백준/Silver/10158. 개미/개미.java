import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    // 상 하 좌 우 좌상 우상 좌하 우하
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer wh = new StringTokenizer(br.readLine());
        StringTokenizer pq = new StringTokenizer(br.readLine());
        
        int w = Integer.parseInt(wh.nextToken());
        int h = Integer.parseInt(wh.nextToken());
        int p = Integer.parseInt(pq.nextToken());
        int q = Integer.parseInt(pq.nextToken());
        int t = Integer.parseInt(br.readLine());
        
        int x = (p+t) % (2*w);
        int y = (q+t) % (2*h);
        
        if(x > w)
        	x = (2*w) - x;
        if(y > h)
        	y = (2*h) - y;
        
        bw.write(x + " " + y);
        bw.flush();
        bw.close();
    }  
}