package Graph.boj_13549;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;
    static int[] check;

    public static void main(String argsp[]) throws Exception {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        check = new int[100001];
        Arrays.fill(check, -1);
    }

    static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int next = start;
        check[next] = 0;
        int[] tmp = new int[3];
        tmp[0] = next + 1;
        tmp[1] = next - 1;
        tmp[2] = next * 2;
        for (int i = 0; i < 3; i++) {
            if(tmp[i] >= 0 && tmp[i] <= 100000){
                if(check[tmp[i]] == -1){

                }
            }
        }
    }
}

