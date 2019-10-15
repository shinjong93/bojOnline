package samsung.boj_17070;

import java.io.*;

public class Main {
    static int N, ans;
    static int[][] board;
    static int[] diagX = {1, 1, 0};
    static int[] diagY = {0, 1, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception {

        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        ans = 0;
        String[] input;
        for (int i = 1; i <= N; i++) {
            input = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                board[j][i] = Integer.parseInt(input[j - 1]);
            }
        }

        solve(2, 1, 1);


        bw.write(ans + "");
        br.close();
        bw.close();
    }

    static void solve(int x, int y, int d) {
        if (x == N && y == N) {
            ans++;
            return;
        }

        if (d != 2 && check(x + 1, y) && board[x + 1][y] == 0) {
            solve(x + 1, y, 1);
        }

        if (d != 1 && check(x, y + 1) && board[x][y + 1] == 0) {
            solve(x, y + 1, 2);
        }

        if (check(x + 1, y + 1) && board[x + 1][y + 1] == 0 && board[x][y + 1] == 0 && board[x + 1][y] == 0) {
            solve(x + 1, y + 1, 3);
        }


    }

    static boolean check(int x, int y) {
        if (x <= N && y <= N)
            return true;
        return false;
    }

}
