package samsung.boj_14502;

import java.util.*;
import java.io.*;

public class Main {

    static int N, M, ANS;
    static int[][] map;
    static int[][] test;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static LinkedList<node> virus = new LinkedList();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ANS = -1;
        map = new int[N][M];
        test = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new node(i, j));
                }
            }
        }

        solve(0, 0);
        System.out.println(ANS);
        br.close();
    }


    static void solve(int start, int wall) {
        if (wall == 3) {
            copy();
            spread();
            count();
            return;
        }

        for (int i = start; i < N * M; i++) {
            int r = i / M;
            int c = i % M;

            if (map[r][c] == 0) {
                map[r][c] = 1;
                solve(start + 1, wall + 1);
                map[r][c] = 0;
            }
        }
    }

    static void progess(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (check(nr, nc) && test[nr][nc] == 0) {
                test[nr][nc] = 2;
                progess(nr, nc);
            }
        }
    }

    static void spread() {
        for (node n : virus) {
            progess(n.r, n.c);
        }
    }

    static void copy() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                test[r][c] = map[r][c];
            }
        }
    }

    static void count() {
        int k = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (test[r][c] == 0) {
                    k++;
                }
            }
        }
        ANS = Math.max(ANS, k);
    }

    static boolean check(int r, int c) {
        if (r >= 0 && r < N && c >= 0 && c < M)
            return true;
        return false;
    }

    static class node {
        int r, c;

        public node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
