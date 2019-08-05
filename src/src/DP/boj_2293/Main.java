package DP.boj_2293;

import java.io.*;
import java.util.*;


public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static int[] dp;
    static int coin;

    public static void main(String args[]) throws Exception {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        dp = new int[m+1];
        dp[0] = 1;

        for(int i = 0; i <n ;i++){
            coin = Integer.parseInt(br.readLine());
            for(int j = 1; j < m+1; j++){
                if( j>= coin){
                    dp[j] += dp[j-coin];
                }
            }
        }
        bw.write(dp[m]+"");
        bw.flush();
        bw.close();
    }

}
