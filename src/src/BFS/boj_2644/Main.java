package BFS.boj_2644;

import java.io.*;
import java.util.*;

public class Main {
    static int N, start, end, Case;
    static Node[] people;
    static int[] visit;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);
        Case = Integer.parseInt(br.readLine());
        people = new Node[N + 1];
        visit = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            people[i] = new Node(i);
            visit[i] = -1;
        }

        for (int i = 0; i < Case; i++) {
            input = br.readLine().split(" ");
            int parent = Integer.parseInt(input[0]);
            int son = Integer.parseInt(input[1]);
            people[parent].sons.add(son);
            people[son].parent.add(parent);
        }

        solve(people[start], 0);

        bw.write(visit[end] + "");

        bw.close();
        br.close();

    }

    /*
    * 시작 노드를 기준으로 촌수를 탐색하여 나가기 때문에, 먼저 도착하여 작성되는 촌수가
    * 시작 노드 기준으로 최소 촌수.
    * */

    static void solve(Node current, int rel) {
        if (visit[end] != -1) { // 목표가 이미 발견 되었을 경우 더이상 탐색하지 않고 종료.
            return;
        }
        if (visit[current.name] != -1) { // 기존에 방문하였던 인원일 경우 더 이상 탐색하지 않고 종료.
            return;
        }
        visit[current.name] = rel; // 시작 기준 촌수

        while (!current.sons.isEmpty()) { // 현재 기준 자식 탐색
            int next = current.sons.poll();
            solve(people[next], rel + 1);
        }

        while (!current.parent.isEmpty()) { // 현재 기준 부모 탐색
            int next = current.parent.poll();
            solve(people[next], rel + 1);
        }
    } // end of solve

    static class Node {
        int name;
        LinkedList<Integer> parent;
        LinkedList<Integer> sons;

        public Node(int name) {
            this.name = name;
            parent = new LinkedList<>();
            sons = new LinkedList<>();
        }

    }
}
