package bruteForce.boj_15649;

import java.io.*;
import java.util.Arrays;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int n, m;
    private static boolean[] used;


    public static void main(String args[]) throws Exception {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        used = new boolean[n + 1];
        Arrays.fill(used, false);


        recursive(0, 0, "");
        bw.flush();
        bw.close();
    }

    private static void recursive(int index, int dist, String ans) throws Exception {
        if (dist == m) {
            bw.write(ans.trim() + "\n");
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                if (!used[i]) {
                    used[i] = true;
                    recursive(i, dist + 1, ans + " " + i);
                    used[i] = false;
                }
            }
        }

    }

}
