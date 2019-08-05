package DP.boj_14501;

import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[] dp, price, time;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 10];
        time = new int[n + 10];
        price = new int[n + 10];
        Arrays.fill(dp, 0);

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            time[i] = Integer.parseInt(input[0]);
            price[i] = Integer.parseInt(input[1]);
        }

        bw.write(sol() + "");
        bw.close();
        br.close();
    }

    private static int sol() {
        int max = 0;
        for (int i = 1; i <= n + 1; i++) {
            dp[i] = Math.max(dp[i], max);
            dp[time[i] + i] = Math.max(dp[time[i] + i], dp[i] + price[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
