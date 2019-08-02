package DP.boj_11052;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] price;
    static int[] dp;

    public static void main(String args[]) throws Exception{
        n = Integer.parseInt(br.readLine());
        price = new int[n+1];
        dp = new int[n+1];
        String[] input = br.readLine().split(" ");
        for(int i = 1; i <= n; i++){
            price[i] = Integer.parseInt(input[i-1]);
        }

        Arrays.fill(dp,0);
        sol();

        bw.write(dp[n]+"");
        bw.flush();
        bw.close();
    }

    static void sol(){
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] = Math.max(dp[i], price[i-j]+dp[j]);
            }
        }
    }
}
