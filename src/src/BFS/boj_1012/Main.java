package BFS.boj_1012;

import java.io.*;
import java.util.*;

public class Main {

    static int row, col, num, ans;
    static int[][] map, visit;
    static int[] rowMove = {-1, 0, 1, 0};
    static int[] colMove = {0, 1, 0, -1};


    public static void main(String args[]) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (true) {
            String[] input = br.readLine().split(" ");
            row = Integer.parseInt(input[0]);
            col = Integer.parseInt(input[1]);
            num = Integer.parseInt(input[2]);

            map = new int[row][col];
            visit = new int[row][col];

            for (int i = 0; i < row; i++) {
                Arrays.fill(map[i], 0);
                Arrays.fill(visit[i], 0);
            }

            for (int i = 0; i < num; i++) {
                input = br.readLine().split(" ");
                int n = Integer.parseInt(input[0]);
                int m = Integer.parseInt(input[1]);
                map[n][m] = 1;
            }

            BFS();

            ans = -1;

            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    ans = Math.max(ans,visit[i][j]);
                }
            }

            bw.write(ans+"\n");

            test--;
            if (test <= 0) {
                bw.close();
                br.close();
                break;
            }
        }// end of while



    } // end of main

    static void BFS() {
        Queue<Node> q = new LinkedList();
        Node tmp;
        int number = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] != 0 && visit[i][j] == 0) {
                    tmp = new Node(i, j);
                    q.add(tmp);
                    number++;

                    while (!q.isEmpty()) {
                        Node curNode = q.poll();
                        int curRow = curNode.row;
                        int curCol = curNode.col;
                        visit[curRow][curCol] = number;

                        for (int k = 0; k < 4; k++) {
                            int nextRow = curRow + rowMove[k];
                            int nextCol = curCol + colMove[k];
                            if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col) {
                                continue;
                            } else {
                                if(map[nextRow][nextCol] != 0 && visit[nextRow][nextCol] == 0){
                                    q.add(new Node(nextRow,nextCol));
                                    visit[nextRow][nextCol] = number;
                                }
                            }
                        }

                    }
                }
            }
        }


    }

    public static class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

}
