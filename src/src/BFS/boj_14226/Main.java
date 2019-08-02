package BFS.boj_14226;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, ans;
    static int[] visit;

    public static void main(String args[]) throws Exception {

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        visit = new int[100001];
        Arrays.fill(visit, -1);

        bw.write(visit[m] + "");
        bw.flush();
        bw.close();
    }

    static void BFS(int start) {
        Deque<Integer> q = new ArrayDeque();
        q.add(start);
        visit[start] = 0;
        q.addFirst(start * 2);
        q.add(start - 1);
        q.add(start + 1);

        while (!q.isEmpty()) {
            int curr = q.poll();
            int twice = curr * 2;
            int up = curr + 1;
            int down = curr - 1;


        }
    }

    static void tmp(int start) {
        Queue<Integer> currentQueue = new LinkedList<>();

        currentQueue.add(start);
        visit[start] = 0;
        int[] tmp = new int[3];

        while (!currentQueue.isEmpty()) {
            Queue<Integer> nextQueue = new LinkedList<>();
            int cur = currentQueue.poll();
            tmp[0] = cur * 2; // 2배
            tmp[1] = cur + 1; // +1
            tmp[2] = cur - 1; // -1

            /*
             * 방문한 곳의 시간이 최소화되는 것을 체크하는 부분이 필요함.
             * 기존에 이미 방문한 곳일 경우, 방문 시간을 비교해서 적은 쪽으로 최신화해야되고,
             * 기존 시간보다 늦을 경우 무시.
             *
             * 체크해야하는 부분
             * 1. 현재 위치가 음수로 떨어질 가능성이 있음.
             * 2. 현재 위치가 10만 초과할 가능성이 있음.
             *
             *
             *
             * */


            for (int i : tmp) {
                if (i < 0 || i > 100000) continue; // 허용 범위 넘기면 패스.
                if (visit[i] == -1) { // 방문한 적이 없는 경우
                    nextQueue.add(i); // 다음 큐에 넣음.
                    if (i == cur * 2) {
                        visit[i] = visit[cur];
                    } else {
                        visit[i] = visit[cur] + 1;
                    }
                } else { // 기존에 방문한 적이 있음 --> 방문 시간을 체크할 것.
                    if (i == cur * 2) { // 순간이동한 케이스
                        if (visit[cur] < visit[i]) { // 기존에 방문한 시간이 더 오래 걸렸을 경우
                            visit[i] = visit[cur]; // 적은 수로 최신화함.
                            nextQueue.add(i); // 다음 큐에 넣는다.
                        }
                    } else {
                        if (visit[cur] + 1 < visit[i]) { // 기존에 방문한 시간이 더 오래 걸렸을 경우
                            visit[i] = visit[cur] + 1;
                            nextQueue.add(i);
                        }
                    }
                }
            }

            if (!nextQueue.isEmpty()) {//넥스트 큐가 존재할 경우
                currentQueue = nextQueue; // 큐를 바꿔준다.
            }
        }// end of while(!currentQueue.isEmpty())

    }


}


