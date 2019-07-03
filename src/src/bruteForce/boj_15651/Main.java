package bruteForce.boj_15651;

import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
    static int n,m;
    static boolean[] used;

    public static void main(String args[]) throws Exception{
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        used = new boolean[n+1];
        Arrays.fill(used,false);
        recursive(0,0, "");
        bw.flush();
        bw.close();
    }

    private static void recursive(int index, int dist, String ans) throws Exception{
        if(dist == m){
            bw.write(ans.trim() + "\n");
            return;
        } else {
            for(int i = 1; i <= n; i++){
                if(dist == m-1){
                    if(!used[i]){
                        used[i] = true;
                        recursive(i,dist+1,ans + " " + i);
                        used[i] = false;
                    }
                } else {
                    recursive(i,dist+1, ans + " " + i);
                }
            }
        }
    }
}
