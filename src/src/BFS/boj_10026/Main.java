package BFS.boj_10026;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map, visit;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        String[] input;
        map = new int[N+1][N+1];
        visit = new int[N+1][N+1];

        for(int i = 1; i <=N; i++){
            input = br.readLine().split("");
            for(int j = 1; j <= N; j++){
                if(input[j-1] == "R"){
                    map[i][j] = 1;
                } else if(input[j-1] == "B"){
                    map[i][j] = 2;
                } else {
                    map[i][j] = 3;
                }
            }
            Arrays.fill(visit[i],0);
        }


    } // end of main

    static void solve(){

    } // end of solve
}
