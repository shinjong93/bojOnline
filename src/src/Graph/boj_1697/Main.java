package Graph.boj_1697;

import java.util.*;
import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[] ans;

    public static void main(String args[]) throws Exception {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        ans = new int[100005];
        Arrays.fill(ans, -1);
        BFS(n);

        bw.write(ans[m] + "");
        bw.flush();
        bw.close();
    }

    static void BFS(int start) throws Exception {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        int next = start;
        ans[next] = 0;
        int[] tmp = new int[3];

        while (!q.isEmpty() && next != m) {
            next = q.poll();
            tmp[0] = next + 1;
            tmp[1] = next - 1;
            tmp[2] = next * 2;
            for (int x : tmp) {
                if (x >= 0 && x <= 100000) {
                    if (ans[x] == -1) {
                        q.add(x);
                        ans[x] = ans[next] + 1;

                    }
                }
            }
        }

    }
}
