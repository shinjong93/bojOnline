package DP.boj_11048;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[][] map;
    static int[][] dp;

    public static void main(String args[]) throws Exception {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];

        for (int row = 1; row <= n; row++) {
            input = br.readLine().split(" ");
            for (int col = 1; col <= m; col++) {
                map[row][col] = Integer.parseInt(input[col - 1]);
            }
        }


        for (int row = 1; row <= n; row++) {
            Arrays.fill(dp[n], 0); // dp배열 초기화
        }

        dp[1][1] = map[1][1];

        for (int row = 2; row <= n; row++) {
            dp[row][1] += map[row][1] + dp[row-1][1];
        }

        for (int col = 2; col <= m; col++) {
            dp[1][col] += map[1][col] + dp[1][col-1];
        }
        // 입력부 끝

        sol();

        //print();

        bw.write(dp[n][m] + "");
        bw.flush();
        bw.close();
        //출력부 끝
    }

    static void sol() throws Exception {
        int[] rowMove = {-1, 0, -1};
        int[] colMove = {0, -1, -1};

        for(int row = 2; row <=n; row++){
            for(int col = 2; col<=m; col++){
                for(int i = 0; i < 3; i++){
                    dp[row][col] = Math.max(dp[row][col], dp[row+rowMove[i]][col+colMove[i]]);
                }
                dp[row][col] += map[row][col];
            }
        }
    }

    static void print() throws Exception {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= m; col++) {
                bw.write(dp[row][col] + " ");
            }
            bw.write("\n");
        }
    }
}
