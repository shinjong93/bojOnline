package BFS.boj_14502;

import java.io.*;
import java.util.*;


public class Main {
    static int n, m;
    static int[][] map;
    static int[][] tmp;
    static int ans;
    static int[] rowMove = {1, 0, -1, 0};
    static int[] colMove = {0, 1, 0, -1};
    static Queue<Node> virus = new LinkedList<>();
    static int INF = -987654;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        tmp = new int[n][m];
        ans = INF;

        for (int r = 0; r < n; r++) {
            input = br.readLine().split(" ");
            for (int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(input[c]);
                if (map[r][c] == 2) {
                    virus.add(new Node(r, c));
                }
            }
        }

        solve(0, 0);

        bw.write(ans + "");
        bw.close();
        br.close();
    }

    static void solve(int start, int num) {
        if (num == 3) {
            copy();
            for (Node node : virus) {
                progress(node.row, node.col);
            }
            ans = Math.max(ans, count());
            return;
        }
        for (int i = start; i < n * m; i++) {
            int x = i / m;
            int y = i % m;

            if (tmp[x][y] == 0) {
                tmp[x][y] = 1;
                solve(i + 1, num + 1);
                tmp[x][y] = 0;
            }
        }
    }

    static void copy() {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                tmp[r][c] = map[r][c];
            }
        }
    }

    static void progress(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + rowMove[i];
            int ny = y + colMove[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (tmp[nx][ny] == 0) {
                    tmp[nx][ny] = 2;
                    progress(nx, ny);

                }
            }
        }
    }

    static int count() {
        int safe = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (tmp[r][c] == 0) safe++;
            }
        }
        return safe;

    }

    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
