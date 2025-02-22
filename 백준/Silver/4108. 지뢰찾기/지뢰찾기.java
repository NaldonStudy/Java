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


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(R==0 && C==0) {
                break;
            }

            char[][] mine = new char[R][C];

            for(int r = 0; r < R; r++) {
                String inMine = br.readLine();
                for(int c = 0; c < C; c++) {
                    mine[r][c] = inMine.charAt(c);
                }
            }

            for(int r = 0; r < R; r++) {
                for(int c = 0; c<C; c++) {
                    if (mine[r][c] == '*'){
                        bw.write('*');
                        continue;
                    } 
                    int cnt = 0;
                    for(int i = 0; i < 8; i++) {
                        if(r+dr[i] >= 0 && r+dr[i]<R && c+dc[i]>=0 && c+dc[i]<C && mine[r+dr[i]][c+dc[i]] == '*') {
                            cnt++;
                        }
                    }
                    bw.write("" + cnt);
                }
                bw.flush();
                bw.newLine();
            }
        }//while문 종료료
        bw.close();
    }  
}