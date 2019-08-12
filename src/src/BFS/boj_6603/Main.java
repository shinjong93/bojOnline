package BFS.boj_6603;

import java.io.*;
import java.util.*;

public class Main {


    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] lotto;
    static int[] ans;
    static int k = 6;

    public static void main(String args[]) throws Exception {
        while (true) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            if (n == 0) break;

            lotto = new int[n+1];
            ans = new int[k+1];

            for(int i = 1; i<=n; i++){
                lotto[i] = Integer.parseInt(input[i]);
            }

            solve(1,n-k+1,1);
            bw.write("\n");
        }
        bw.close();
        br.close();
    }

    static void solve(int start, int end, int cur) throws Exception{
        if(cur > k){
            for(int i = 1; i <= k; i++){
                bw.write(ans[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = start; i <= end; i++){
                ans[cur] = lotto[i];
                solve(i+1,end+1,cur+1);

        }
    }

}
