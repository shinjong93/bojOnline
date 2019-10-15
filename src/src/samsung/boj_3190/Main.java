package samsung.boj_3190;

import java.io.*;
import java.util.*;

public class Main {

    static int N,K,L,d,result;
    static int[][] map;
    static int[] time;
    static int[] dir;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine().trim());
        K = Integer.parseInt(br.readLine().trim());
        map = new int[N+1][N+1] ;
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine().trim(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        L = Integer.parseInt(br.readLine().trim());
        time = new int[L];
        dir = new int[L];
        for(int i = 0; i < L; i++){
            st = new StringTokenizer(br.readLine().trim(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            if(s.equals("D")){
                dir[i] = 1;
            } else if(s.equals("L")){
                dir[i] = 3;
            }
        }

        solve();
    }


    static void solve(){
        int second = 0;
        int vec = 1;
        int idx = 0;
        map[1][1] = 2;
        Deque<point> snake = new ArrayDeque<>();
        snake.add(new point(1,1));
        while(true){
            if(idx < L && time[idx] == second){
                vec = (vec + dir[idx])%4;
                idx++;
            }

            int nx = snake.getFirst().x + dx[vec];
            int ny = snake.getFirst().y + dy[vec];

            if(nx <= 0 || nx > N || ny <= 0 || ny > N){
                System.out.println(second+1);
                return;
            }
            if(map[nx][ny] == 2){
                System.out.println(second+1);
                return;
            }

            if(map[nx][ny] == 1){
                map[nx][ny] = 2;
                snake.addFirst(new point(nx,ny));
            }
            else if(map[nx][ny] == 0){
                map[nx][ny] = 2;
                snake.addFirst(new point(nx,ny));
                point tail = snake.removeLast();
                map[tail.x][tail.y] = 0;
            }
            second++;
        }
    }

    static class point {
        int x, y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
