package bruteForce.boj_15653;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int n, m;
    static int[] nums;
    static boolean[] used;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws Exception {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        nums = new int[n + 1];
        used = new boolean[n + 1];
        Arrays.fill(used, false);
        input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(input[i - 1]);
        }
        Arrays.sort(nums);
        recursive(0, 0, "");
        bw.flush();
        bw.close();
    }

    static void recursive(int index, int dist, String ans) throws Exception {
        if (dist == m) {
            bw.write(ans.trim() + "\n");
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                if (!used[i]) {
                    used[i] = true;
                    recursive(i, dist + 1, ans + " " + nums[i]);
                    used[i] = false;
                }
            }
        }
    }
}
