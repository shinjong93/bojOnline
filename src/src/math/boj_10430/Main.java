package math.boj_10430;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));


    public static void main(String args[]) throws Exception {
        String[] a = br.readLine().split(" ");
        int A = Integer.parseInt(a[0]);
        int B = Integer.parseInt(a[1]);
        int C = Integer.parseInt(a[2]);

        bw.write((A + B) % C + "\n");
        bw.write((A % C + B % C) % C + "\n");
        bw.write((A * B) % C + "\n");
        bw.write((A % C * B % C) % C + "\n");

        bw.flush();
        bw.close();
    }
}
