import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        List<Integer>[] computer = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            computer[i] = new ArrayList<>();
        }

        for(int i = 0; i < C; i++) {
            StringTokenizer SE = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(SE.nextToken());
            int e = Integer.parseInt(SE.nextToken());

            computer[s].add(e);
            computer[e].add(s);
        }

        boolean[] visited = new boolean[N + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int count = 0;

        while (!q.isEmpty()) {
            int start = q.poll();
            if(visited[start]) continue;

            visited[start] = true;
            count++;

            for(int next : computer[start]) {
                if(!visited[next]) {
                    q.offer(next);
                }
            }
        }
        bw.write(""+(count-1));
        bw.flush();
        bw.close();
    }
}