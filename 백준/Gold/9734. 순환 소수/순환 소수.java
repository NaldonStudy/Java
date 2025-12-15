import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;

        // 입력이 끝날 때까지 읽음
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            solve(line, bw);
        }

        bw.flush();
        bw.close();
    }

    private static void solve(String s, BufferedWriter bw) throws IOException {
        // 파싱하기
        int dotIndex = s.indexOf('.');
        int parenIndex = s.indexOf('(');

        String integerPart = s.substring(0, dotIndex);
        String nonRepeating = s.substring(dotIndex + 1, parenIndex);
        String repeating = s.substring(parenIndex + 1, s.length() - 1);

        // 1. 분자를 계산
        // 전체 수 - 순환하지 않는 부분
        String allDigitsStr = integerPart + nonRepeating + repeating;
        long allDigits = Long.parseLong(allDigitsStr);

        String nonRepeatingPartStr = integerPart + nonRepeating;
        long nonRepeatingNum = Long.parseLong(nonRepeatingPartStr);

        long numerator = allDigits - nonRepeatingNum;

        // 2. 분모를 계산
        // 순환하는 자릿수만큼 9, 비순환 소수부만큼 0
        StringBuilder denomStr = new StringBuilder();
        for (int i = 0; i < repeating.length(); i++) {
            denomStr.append('9');
        }
        for (int i = 0; i < nonRepeating.length(); i++) {
            denomStr.append('0');
        }
        long denominator = Long.parseLong(denomStr.toString());

        // 3. 약분
        long gcd = getGCD(numerator, denominator);

        bw.write(s + " = " + (numerator / gcd) + " / " + (denominator / gcd));
        bw.newLine();
    }

    // 약분함수
    private static long getGCD(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}