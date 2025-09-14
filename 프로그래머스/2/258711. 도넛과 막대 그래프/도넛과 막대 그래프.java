import java.util.*;

class Solution {
    static final int MAX = 1000000;

    public int[] solution(int[][] edges) {
        int[] in = new int[MAX + 1];
        int[] out = new int[MAX + 1];
        boolean[] seen = new boolean[MAX + 1];

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            out[u]++; in[v]++;
            seen[u] = true; seen[v] = true;
        }

        // 시작 정점: in=0 && out>=2 (등장한 노드만)
        int start = 0;
        for (int i = 1; i <= MAX; i++) {
            if (!seen[i]) continue;
            if (in[i] == 0 && out[i] >= 2) { start = i; break; }
        }

        int sticks = 0, eights = 0;
        for (int i = 1; i <= MAX; i++) {
            if (!seen[i] || i == start) continue;
            if (out[i] == 0) sticks++;               // 막대: 말단(out=0)
            if (out[i] == 2 && in[i] >= 2) eights++; // 8자: 만나는 점(out==2, in>=2)
        }

        int donuts = out[start] - sticks - eights;
        return new int[] { start, donuts, sticks, eights };
    }
}
