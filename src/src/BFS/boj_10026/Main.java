package BFS.boj_10026;

import java.io.*;
import java.util.*;

public class Main {

    static int N, areaNum;
    static int[][] map, visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception {

        N = Integer.parseInt(br.readLine());
        areaNum = 0;
        String[] input;
        map = new int[N + 1][N + 1];
        visit = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            input = br.readLine().split("");
            for (int j = 1; j <= N; j++) {
                if (input[j - 1].equals("R")) {
                    map[i][j] = 1;
                } else if (input[j - 1].equals("B")) {
                    map[i][j] = 2;
                } else {
                    map[i][j] = 3;
                }
            }
            Arrays.fill(visit[i], 0);
        }


        for (int x = 1; x <= N; x++) { // 모든 점에서 재귀탐색 --> 영역 지도가 매 시행마다 업데이트
            for (int y = 1; y <= N; y++) {
                if (visit[x][y] == 0) { // 아직 영역이 확정되지 않은 곳이 있을 경우
                    areaNum++; // 새로운 영역
                    solve(x, y, areaNum); // 재귀로 같은 영역 탐색
                }
            }
        }

        bw.write( areaNum + " ");

        // 영역값 및 영역 지도 초기화.
        areaNum = 0;
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visit[i], 0);
        }

        // 적-록 색상 통일
        changeColor();

        // 다시 재귀 탐색.
        for (int x = 1; x <= N; x++) { // 모든 점에서 재귀탐색 --> 영역 지도가 매 시행마다 업데이트
            for (int y = 1; y <= N; y++) {
                if (visit[x][y] == 0) { // 아직 영역이 확정되지 않은 곳이 있을 경우
                    areaNum++; // 새로운 영역
                    solve(x, y, areaNum); // 재귀로 같은 영역 탐색
                }
            }
        }


        //출력
        bw.write(areaNum + "");
        bw.close();
        br.close();
    } // end of main

    static void solve(int x, int y, int areaNum) {
        if (visit[x][y] != 0) {
            return;
        }
        visit[x][y] = areaNum; // 영역을 확정하고
        for (int i = 0; i < 4; i++) { // 상하좌우 탐색
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 1 && nextX <= N && nextY >= 1 && nextY <= N) { // 좌표 벗어나지 않는 범위에서
                if (map[x][y] == map[nextX][nextY]) { // 현재 영역과 인접 영역이 같은 색상일 경우
                    solve(nextX, nextY, areaNum); // 재귀탐색
                }
            }
        }

    } // end of solve

    static void changeColor() throws Exception { // 적-녹을 하나로 통일
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                if(map[x][y] == 1) map[x][y] = 3;
            }
        }
    } //  end of changeColor
} // end of Main
