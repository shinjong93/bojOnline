package samsung.boj_13460;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M, result;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String args[]) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int redX, redY, blueX, blueY;
        result = 0;
        board = new int[N][M];
        ball red, blue;
        for (int i = 0; i < N; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if (input[j].equals("#")) {
                    board[i][j] = -1;
                } else if (input[j].equals(".")) {
                    board[i][j] = 0;
                } else if (input[j].equals("R")) {
                    board[i][j] = 1;
                    red = new ball(i, j, 1);
                } else if (input[j].equals("B")) {
                    board[i][j] = 2;
                    blue = new ball(i, j, 2);
                } else if (input[j].equals("O")) {
                    board[i][j] = 9;
                }
            }
        }


        br.close();
        bw.close();
    } // end of main


    static void solve(game start) {
        Queue<game> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            game g = q.poll();
            if (g.count > 10) continue;
            ball red = g.red;
            ball blue = g.blue;
            int[][] map = g.map;


            for (int i = 0; i < 4; i++) {
                int nextX = red.x+dx[i];
                int nextY = red.y+dx[i];
                if(map[nextY][nextX] == 0 || map[nextY][nextX] == 9){

                }
            }

        }
    }

    static int[][] up(int y, int x, int[][] map, int color) {
        int next = y;
        while (map[next][x] == 0) {
            next -= 1;
        }
        map[y][x] = 0;
        map[next][x] = color;
        return map;
    }

    static int[][] down(int y, int x, int[][] map, int color) {
        int next = y;
        while (map[next][x] == 0) {
            next += 1;
        }
        map[y][x] = 0;
        map[next][x] = color;
        return map;
    }

    static int[][] left(int y, int x, int[][] map, int color) {
        int next = x;
        while (map[y][next] == 0) {
            next -= 1;
        }
        map[y][x] = 0;
        map[y][next] = color;
        return map;
    }

    static int[][] right(int y, int x, int[][] map, int color) {
        int next = x;
        while (map[y][next] == 0) {
            next += 1;
        }
        map[y][x] = 0;
        map[y][next] = color;
        return map;
    }

    static class game {
        ball blue, red;
        int[][] map;
        int count;
        int last = -1;

        public game(ball blue, ball red, int[][] map) {
            this.blue = blue;
            this.red = red;
            this.map = map;
            count = 0;
        }


    }

    static class ball {
        int x, y, color;

        public ball(int y, int x, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
