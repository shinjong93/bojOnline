package BFS.boj_11724;

import java.io.*;
import java.util.*;

public class Main {

    static int n, m, ans;
    static int[][] map;
    static int[] visit;
    static int group = 0;

    public static void main(String args[]) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        ans = 1;


        map = new int[n+1][n+1];
        visit = new int[n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], 0);
        }

        int start, end;
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            start = Integer.parseInt(input[0]);
            end = Integer.parseInt(input[1]);
            map[start][end] = map[end][start] = 1;
        }


        for(int i = 1; i <= n; i++){
            if(visit[i] == 0){
                group++;
                solve(i);
            }
        }

        bw.write(group + "");


        bw.close();
        br.close();
    }

    static void solve(int  node) {
        visit[node] = group;
        for(int i = 1; i <= n; i++){
            if(map[node][i] == 1 && visit[i] == 0){
                solve(i);
            }
        }
    }


}
