package samsung.boj_13458;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long result;
    static int[] room;
    static int[] direct;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        room = new int[N];
        direct = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        for (int i = 0; i < N; i++) {
            room[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine().trim(), " ");
        direct[0] = Integer.parseInt(st.nextToken());
        direct[1] = Integer.parseInt(st.nextToken());

        solve();

        bw.write(result + "");
        br.close();
        bw.close();
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            result += 1;
            room[i] -= direct[0];
            if (room[i] > 0)
                result += Math.ceil(1.0 * room[i] / direct[1]);
        }
    }
}
//Math.ceil(1.0 * room[i] / direct[1])
//
//출처: https://mygumi.tistory.com/248 [마이구미의 HelloWorld]