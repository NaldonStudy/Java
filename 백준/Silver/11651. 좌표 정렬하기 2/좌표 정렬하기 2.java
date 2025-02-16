import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N];
        int[] y = new int[N];
        
        int[] xCntArr = new int[200001];		// -100,000부터 100,000 가운데는 [100,000]
        int[] yCntArr = new int[200001];
        
        // 일단 배열에 담는다.
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());	
        	x[i] = Integer.parseInt(st.nextToken());
        	xCntArr[100000 + x[i]]++;
        	y[i] = Integer.parseInt(st.nextToken());
        	yCntArr[100000 + y[i]]++;
        }
        
        // 누적합으로 변경
        for(int i = 1; i<xCntArr.length; i++) {
        	xCntArr[i] = xCntArr[i] + xCntArr[i-1];
        	yCntArr[i] = yCntArr[i] + yCntArr[i-1];
        }
        
        // x기준 sort된거
        int[] xXSorted = new int[N];
        int[] yXSorted = new int[N];
        // 그렇게 정렬된걸 바탕으로 x도 다시 정렬
        for (int i = N-1; i >= 0; i--) {
        	int temp = --xCntArr[100000 + x[i]];	// 찾을 위치에 있는거 1개 줄이기
        	yXSorted[temp] = y[i];					// sort될 공간에 집어넣기
        	xXSorted[temp] = x[i];
        }
        
        // x가 y기존sort된거
        int[] xYSorted = new int[N];
        int[] yYSorted = new int[N];

        // y부터 정렬할건데. 이 때 카운팅정렬
        for (int i = N-1; i >= 0; i--) {
        	int temp = --yCntArr[100000 + yXSorted[i]];	// 찾을 위치에 있는거 1개 줄이기
        	yYSorted[temp] = yXSorted[i];					// sort될 공간에 집어넣기
        	xYSorted[temp] = xXSorted[i];
        }
        
        for (int i = 0; i < N; i++) {
        	bw.write(xYSorted[i] + " " + yYSorted[i] + "\n");
        	bw.flush();
        }
        bw.close();
    }
}