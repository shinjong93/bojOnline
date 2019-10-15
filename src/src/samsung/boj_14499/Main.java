package samsung.boj_14499;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] orders;


    public static void main(String args[]) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        orders = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int order;
        st = new StringTokenizer(br.readLine().trim(), " ");
        for (int i = 0; i < K; i++) {
            order = Integer.parseInt(st.nextToken());
            if (order == 2) {
                orders[i] = ++order;
            } else if (order == 3) {
                orders[i] = --order;
            } else {
                orders[i] = order;
            }
        }


    }



    static dice rollDir(dice d, int dir) {
        dice tmp = new dice(0);
        if (dir == 1) {// 오른쪽 굴림.
            d.connect[2].LRroll(1);
            d.connect[4].LRroll(-1);
            tmp = d.roll(dir);
        } else if (dir == 2) { // 위쪽 굴림
            d.connect[1].UDroll(1);
            d.connect[3].UDroll(-1);
            tmp = d.roll(dir);
        } else if(dir == 3){ //좌측 굴림
            d.connect[2].LRroll(-1);
            d.connect[4].LRroll(1);
            tmp = d.roll(dir);
        } else if(dir == 4){ //아래 굴림
            d.connect[1].UDroll(-1);
            d.connect[3].UDroll(1);
            tmp = d.roll(dir);
        }
        return tmp;
    }


    static void makeDice() {
        dice d1 = new dice(0);
        dice d2 = new dice(0);
        dice d3 = new dice(0);
        dice d4 = new dice(0);
        dice d5 = new dice(0);
        dice d6 = new dice(0);

        d1.makeConnect(d3, 1);
        d1.makeConnect(d2, 2);
        d1.makeConnect(d4, 3);
        d1.makeConnect(d5, 4);
        d1.makeConnect(d6, 5);

        d2.makeConnect(d3, 1);
        d2.makeConnect(d6, 2);
        d2.makeConnect(d4, 3);
        d2.makeConnect(d1, 4);
        d2.makeConnect(d5, 5);

        d3.makeConnect(d6, 1);
        d3.makeConnect(d2, 2);
        d3.makeConnect(d1, 3);
        d3.makeConnect(d5, 4);
        d3.makeConnect(d4, 5);

        d4.makeConnect(d1, 1);
        d4.makeConnect(d2, 2);
        d4.makeConnect(d6, 3);
        d4.makeConnect(d5, 4);
        d4.makeConnect(d3, 5);

        d5.makeConnect(d3, 1);
        d5.makeConnect(d1, 2);
        d5.makeConnect(d4, 3);
        d5.makeConnect(d6, 4);
        d5.makeConnect(d2, 5);

        d6.makeConnect(d3, 1);
        d6.makeConnect(d5, 2);
        d6.makeConnect(d4, 3);
        d6.makeConnect(d2, 4);
        d6.makeConnect(d1, 5);
    }


    static class dice {
        int UD;
        int LR;// 주사위 굴림에 따른 연결 변경도
        int value; // 주사위에 적힌 번호 > 디폴트 0
        dice[] connect;

        public dice(int value) {
            this.UD = 0;
            this.LR = 0;
            this.value = value;
            connect = new dice[6];
        }

        public void makeConnect(dice d, int idx) {
            this.connect[idx] = d;
        }

        public int upper() {
            return this.connect[5].value;
        }

        public dice roll(int dir){
            if(dir == 1 || dir == 3){
                dir = dir + LR;
            } else if(dir == 2 || dir == 4) {
                dir = dir + UD;
            }
            if(dir > 4){
                dir = 1;
            } else if(dir < 0){
                dir = 4;
            }

            return connect[dir];
        }

        public void LRroll(int k) {
            if (LR + k < 0) {
                LR = 3;
            } else if (LR > 4) {
                LR = 0;
            }
        }

        public void UDroll(int k) {
            if (UD + k < 0) {
                UD = 3;
            } else if (UD > 4) {
                UD = 0;
            }
        }
    }
}
