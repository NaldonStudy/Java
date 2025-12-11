import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int pos;
        int type; // 시작점이면 1, 끝점 다음이면 -1

        public Point(int pos, int type) {
            this.pos = pos;
            this.type = type;
        }
    }

    static class Interval {
        int s, e, idx;

        public Interval(int s, int e, int idx) {
            this.s = s;
            this.e = e;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Point> points = new ArrayList<>();
        List<Interval> intervals = new ArrayList<>();

        for (int n = 1; n <= N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            // 나중에 정답(인덱스) 출력을 위해 원본 저장
            intervals.add(new Interval(s, e, n));

            // 스위핑을 위한 포인트 추가
            points.add(new Point(s, 1));       // 시작점: +1
            points.add(new Point(e + 1, -1));  // 끝점 다음: -1
        }

        // 람다식을 이용한 정렬
        points.sort((p1, p2) -> {
            if (p1.pos == p2.pos) {
                // 좌표가 같다면 type 오름차순 정렬 (-1 먼저, 그 다음 1)
                // 같은 좌표에서 끝나는 걸 먼저 처리해야 겹치는 수 집계가 정확함
                return Integer.compare(p1.type, p2.type);
            }
            // 좌표 오름차순 정렬
            return Integer.compare(p1.pos, p2.pos);
        });

        int maxOverlap = 0;
        int currentOverlap = 0;
        int bestPos = -1;

        // 정렬된 포인트를 순서대로 훑기 (Sweeping)
        for (Point p : points) {
            currentOverlap += p.type;

            if (currentOverlap > maxOverlap) {
                maxOverlap = currentOverlap;
                bestPos = p.pos;
            }
        }

        // 정답 출력
        bw.write(maxOverlap + "\n");

        StringBuilder sb = new StringBuilder();
        for (Interval iv : intervals) {
            // bestPos가 해당 구간 안에 포함되는지 확인
            if (iv.s <= bestPos && bestPos <= iv.e) {
                sb.append(iv.idx).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}