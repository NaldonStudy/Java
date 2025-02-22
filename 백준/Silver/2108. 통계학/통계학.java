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
        double[] nums = new double[N];
        double sum = 0;
        int[] numcnt = new int[8001];
        int cntMax = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < N; i++) {
        	double temp = Integer.parseInt(br.readLine());
        	nums[i] = (int) temp;
        	sum+= temp;
        	numcnt[4000 + (int) temp]++;
        	if(numcnt[4000+(int) temp] > cntMax) {
        		cntMax = numcnt[4000+(int) temp]; 	// 가장 많이 카운트 된게 몇개인지 확인
        	}
        	if ((int) temp > max)
        		max = (int) temp;		// 범위 설정을 위해 최대
        	if((int) temp < min) {
        		min = (int) temp;		// 범위 설정을 위해 최소
        	}
        }
        
        // 산술 평균
        int avg = (int) Math.round(sum / N);
        bw.write(""+avg);
        bw.newLine();
        
        // 중앙값
        Arrays.sort(nums);
        int midVal = (int) nums[N/2];
        bw.write(""+midVal);
        bw.newLine();
        
        // 최빈값, 여러개면 두번째로 작은 값
        int freqVal = 0;
        int freq = 0;
        for(int i = 0; i < 8001; i++) {
        	if(numcnt[i] == cntMax) {
        		freqVal = i-4000;
        		if(++freq == 2)
        			break;	// 같은 값 2번 나오면 탈출
        	}
        }
        bw.write(""+freqVal);
        bw.newLine();
        
        // 범위
        int numRange = max - min;
        bw.write(""+numRange);
        bw.flush();
        bw.close();
    }
}