package samsung.boj_14890;

import java.io.*;
import java.util.*;

public class Main {
    static int N, L, ANS;
    static int[][] map;
    static int[] row;
    static int[] col;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        ANS = 0;
        map = new int[N + 1][N + 1];
        row = new int[N + 1];
        col = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            row[i] = 1;
            col[i] = 1;
            for (int j = 0; j <= N; j++) {
                map[i][j] = Integer.parseInt(input[i - 1]);
            }
        }

        solve();
        ANS = count();

        for (int i : row) {
            bw.write(i + " ");
        }
        bw.write("\n");
        for (int i : col) {
            bw.write(i + " ");
        }
        bw.write("\n");

        //  bw.write(ANS+"");
        bw.close();
        br.close();

    }

    static void solve() {
        /*
         * 높이가 변하는 경우는 2개.
         * 진행하다가 높아지는 경우 > ㄱ
         * 진행하다가 낮아지는 경우 > ㄴ
         * 필요한 변수는 x = 현재 높이/y= 다음 블럭의 높이/z= 현재까지 진행한 동일 높이의 블럭/
         *
         * ㄱ의 경우에는 x < y 인 경우이므로 이미 진행해 온 길에다 경사로를 설치해야한다. 즉, z 가 L보다 커야하며,
         * 경사로를 놓고 위로 올라간 이후에는 z가 초기화 된다.
         *
         * ㄴ의 경우에는 x > y 인 경우이므로 현재 위치에서 L개 만큼 진행할 수 있는지, 그리고 그 블럭들이 모두 높이가 동일한 지 체크해야한다.
         * 둘 중 하나라도 안되면 못 지나감. 이 경우에도 z는 초기화 된다.
         *
         * 높이가 변화하면 z는 무조건 초기화 됨.
         *
         * 올라가는 경우에는 변화점 이전 동일 높이 블럭이 L개 이상 존재해야한다.
         * 내려가는 경우에는 변화점 이후 동일 높이 블럭이 L개 이상 존재하야한다.
         * 경사로를 설치하여 올라가거나 내려가는 것에 성공할 경우, 동일 높이 블럭 갯수를 초기화하고 다시 센다.
         *
         * 맞붙은 블럭이 높이 차이가 2 이상일 경우 위 조건에 무관하게 지나갈 수 없다.
         *
         * */
    }

    static int count() {
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (row[i] == 1) result++;
            if (col[i] == 1) result++;
        }
        return result;
    }

    static boolean check(int x, int l) {
        return (x + l <= N) ? true : false;
    }

}


