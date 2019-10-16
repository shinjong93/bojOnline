package samsung.boj_14889;

import java.util.*;
import java.io.*;

public class Main {
    static int N, half, total;
    static int ANS = 987654321;
    static int[][] member;
    static int[] teamA, teamB, check;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        N = Integer.parseInt(st.nextToken());
        half = N / 2;
        member = new int[N + 1][N + 1];
        teamA = new int[half + 1];
        teamB = new int[half + 1];
        check = new int[N + 1];
        total = 0;

        Arrays.fill(teamB, 0);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            check[i] = 0;
            for (int j = 1; j <= N; j++) {
                member[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        solve(1, 1);

        bw.write(+ANS + "");
        bw.close();
        br.close();
    }

    static void solve(int start, int idx) throws Exception {
        if (idx > half) {
            ANS = Math.min(ANS, count(teamA));
            reset();
            return;
        }
        for (int i = start; i <= N; i++) {
            teamA[idx] = i;
            solve(i + 1, idx + 1);
        }
    }

    static void reset() {
        for (int i = 1; i <= N; i++) {
            check[i] = 0;
        }
    }


    static int count(int[] teamA) {

        int a = 0;
        int b = 0;

        for (int a1 : teamA) {
            for (int a2 : teamA) {
                if (a1 == a2) continue;
                a += member[a1][a2];
            }
        }

        for (int a1 : teamA) {
            check[a1] = -1;
        }

        int idx = 1;
        for (int i = 1; i <= N; i++) {
            if (check[i] == -1) continue;
            teamB[idx] = i;
            idx++;
        }

        for (int b1 : teamB) {
            for (int b2 : teamB) {
                if (b1 == b2) continue;
                b += member[b1][b2];
            }
        }


        return Math.abs(a - b);
    }
}
