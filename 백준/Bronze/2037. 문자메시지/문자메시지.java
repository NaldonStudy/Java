import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[][] keyPad = { { "A", "B", "C" }, { "D", "E", "F" }, { "G", "H", "I" }, { "J", "K", "L" },
				{ "M", "N", "O" }, { "P", "Q", "R", "S" }, { "T", "U", "V" }, { "W", "X", "Y", "Z" } };

		StringTokenizer inNums = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(inNums.nextToken());
		int w = Integer.parseInt(inNums.nextToken());

		String inString = br.readLine();
		char[] inChar = inString.toCharArray(); // 이러면 공백도 하나씩 다 저장댐

		int timeCnt = 0;
		
		// 마지막 경우는 특이케이스니깐 빼고 계산
		for (int i = 0; i < inChar.length-1; i++) {
			// 빈칸이 나오는 경우는 굳이 해야해? -> 그냥 넘겨야지
			if (inChar[i] == ' ') {
				timeCnt += p;
			} else {
				// 여기서 자리수가 있는 위치 확인. p부터 계산해보자
				for (int j = 0; j < keyPad.length; j++) {
					if (Arrays.asList(keyPad[j]).indexOf(String.valueOf(inChar[i])) != -1) { // 이러면 index위치를 알려줌. 없으면 -1
						timeCnt += (Arrays.asList(keyPad[j]).indexOf(String.valueOf(inChar[i])) + 1) * p; // 이건 인덱스 위치 *p만큼 시간소요
						// 다음 위치에 있는애도 지금 애랑 같은 키페드에 존재하면 10초를 추가
						if (Arrays.asList(keyPad[j]).indexOf(String.valueOf(inChar[i + 1])) != -1)
							timeCnt += w;
					}
				}
			}
		}
		// 마지막 케이스는 따로 계산
		for (int idx = 0; idx < keyPad.length; idx++) {
			if (Arrays.asList(keyPad[idx]).indexOf(String.valueOf(inChar[inChar.length - 1])) != -1) { // 이러면 index위치를 알려줌. 없으면 -1
				timeCnt += (Arrays.asList(keyPad[idx]).indexOf(String.valueOf(inChar[inChar.length - 1])) + 1) * p; // 이건 인덱스 위치 *2만큼 시간소요
			}
		}
		bw.write(String.valueOf(timeCnt));
		bw.flush();
		bw.close();
	}
}