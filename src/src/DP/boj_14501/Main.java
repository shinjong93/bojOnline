package DP.boj_14501;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] dp;
    static int[] price;
    static int[] time;
    static int max;


    public static void main(String args[]) throws Exception {
        n = Integer.parseInt(br.readLine());
        String[] input = new String[2];
        dp = new int[n + 10];
        time = new int[n + 10];
        price = new int[n + 10];
        max = 0;
        Arrays.fill(dp, 0);


        for (int i = 1; i <= n; i++) {
            input = br.readLine().split(" ");
            time[i] = Integer.parseInt(input[0]);
            price[i] = Integer.parseInt(input[1]);
        }

        sol();
        bw.write(max+"");
        bw.flush();
        bw.close();

    }

    static void sol() {
        for (int i = 1; i <= n + 1; i++) {
            dp[i] = Math.max(dp[i], max);
            dp[time[i] + i] = Math.max(dp[time[i] + i], dp[i] + price[i]);
            max = Math.max(max, dp[i]);
        }
    }

}
