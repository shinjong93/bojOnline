package Graph.boj_14226;

import java.util.*;
import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int s, ans;
    static int[] check;

    public static void main(String args[]) throws Exception {
        s = Integer.parseInt(br.readLine());
        ans = 987654321;
        check = new int[1001];
        Arrays.fill(check, -1);
        DFS(new node(1, 1, 1));
        bw.flush();
        bw.close();
    }

    static void DFS(node start) throws Exception {
        Queue<node> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            node cur = q.poll();
           // bw.write("현재 모니터 = " + cur.monitor + "/// 현재 클립보드 = " + cur.clip + "/// 현재 시간 = " + cur.sec + "\n");
            // 방문한 적이 없을 경우.
            //check[cur.monitor] = cur.sec;
            if(cur.sec < ans){
                if (cur.monitor < s) {
                    q.add(cur.addClip());
                    q.add(cur.makeClip());
                } else if (cur.monitor > s) {
                    q.add(cur.deleteMonitor());
                } else if (cur.monitor == s) {
                    if (cur.sec < ans) {
                        ans = cur.sec;
                        bw.write(ans + "");
                        return;
                    }
                }
            }

        }
    }

    static class node {
        public int clip;
        public int monitor;
        public int sec;

        public node(int clip, int monitor, int sec) {
            this.clip = clip;
            this.monitor = monitor;
            this.sec = sec;
        }

        public node makeClip() {
            return new node(monitor, monitor, sec + 1);
        }

        public node addClip() {
            return new node(clip, monitor + clip, sec + 1);
        }

        public node deleteMonitor() {
            return new node(clip, monitor - 1, sec + 1);
        }
    }
}
