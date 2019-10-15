package DP.boj_1309;

import java.io.*;

public class Main {

    static int N;
    static int div = 9901;
    static int[] DP;

    public static void main(String args[]) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DP = new int[N+1];
        DP[0] = 1;
        DP[1] = 3;

        solve(N);

        bw.write(DP[N]+"");
        bw.close();
        br.close();
    }

    static void solve(int n){
        for(int i = 2; i <=n; i++){
            DP[i] = (2*DP[i-1] + DP[i-2])%div;
        }
    }
}
