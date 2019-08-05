package DP.boj_2294;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int[] coins;
    static int[] dp;

    public static void main(String args[]) throws Exception{
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        coins = new int[n+1];
        dp = new int[m+1];
        Arrays.fill(dp,10001);
        for(int i = 1; i <= n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }


        Arrays.sort(coins);

        dp[0] = 0;


        sol();



        if(dp[m] == 10001){
            bw.write(-1 + "");
        } else {
            bw.write(dp[m] + "");
        }
        bw.flush();
        bw.close();
    }


    static void sol(){
        for(int i = 1; i <=n; i++){
            for(int j = coins[i]; j <=m; j++){
                dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
            }
        }

    } // end of sol()

}
