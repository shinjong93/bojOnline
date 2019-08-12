package BFS.boj_11403;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map, visit, ans;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        visit = new int[n + 1][n + 1];

        String[] input;

        for (int r = 1; r <= n; r++) {
            input = br.readLine().split(" ");
            for (int c = 1; c <= n; c++) {
                map[r][c] = Integer.parseInt(input[c - 1]);
            }
        }

        for (int i = 1; i <= n; i++) {
            Arrays.fill(visit[i], 0);
        }


        solve();


        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                bw.write(visit[r][c] + " ");
            }
            bw.write("\n");
        }

        bw.close();
        br.close();

    }

    static void solve() {
        for(int i = 1; i <=n; i++){
            Queue<Integer> q = new LinkedList();

            boolean[] visited = new boolean[n+1];

            q.add(i);

            while(!q.isEmpty()){
                int cur = q.poll();
                for(int j = 1; j<=n;j++){
                    if(map[cur][j] == 1 && visited[j] != true){
                        q.add(j);
                        visited[j] = true;
                        visit[i][j] = 1;
                    }
                }
            }
        }
    }
}
