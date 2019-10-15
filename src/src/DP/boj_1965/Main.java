package DP.boj_1965;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int MAX = -1;
    static int[] nums,DP;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        nums = new int[N+1];
        DP = new int[N+1];

        for(int i = 1; i <= N; i++){
            nums[i] = Integer.parseInt(input[i-1]);
        }

        Arrays.fill(DP,1);

        sol();

        for(int i = 1; i <=N; i++){
            MAX = Math.max(MAX,DP[i]);
        }

        bw.write(MAX+"");
        bw.close();
        br.close();
    }

    static void sol(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j < i; j++){
                if(nums[i] > nums[j]){
                    DP[i] = Math.max(DP[i],DP[j]+1);
                }
            }
        }
    }
}
