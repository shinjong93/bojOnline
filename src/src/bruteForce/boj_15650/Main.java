package bruteForce.boj_15650;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int n, m;
    static boolean[] used;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception {

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        used = new boolean[n+1];
        Arrays.fill(used,false);
        recursive(0,0,0,"");
        bw.flush();
        bw.close();
    }

    private static void recursive(int index, int dist, int before, String ans) throws Exception {
        if (dist == m) {
            bw.write(ans.trim() + "\n");
            return;
        } else {
            for(int i = 0; i <= n; i++){
                if(!used[i]){
                    if(i > before){
                        used[i] = true;
                        recursive(i,dist+1,i,ans+" "+i);
                        used[i]=false;
                    }
                }
            }
        }
    }

}
