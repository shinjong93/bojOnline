package DP.boj_1699;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] dp;
    static int INF = 1234567890;


    public static void main(String args[]) throws Exception{
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        Arrays.fill(dp,INF);

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;


        sol();

        bw.write(dp[n]+"");
        bw.flush();
        bw.close();
    }

    static void sol(){
        for(int i = 4; i <= n; i++){
            for(int j = 100; j >=1; j--){
                if(i >= j*j){
                    dp[i] = dp[i%(j*j)] +1;
                    break;
                }
            }
        }
    }

    /**
     * 목표 수 n 에 대하여
     * 자연수 k.
     * k^2 < n < (k+1)^2 을 만족하는 k를 찾을 것.
     * dp[n] = dp[n-k^2] + 1 이 된다.
     *
     * m = (n-k^2) 역시
     * i^2 < m < (i+1)^2 을 만족할 가능성이 있으니 고민해 볼 것.
     */
}
