package bruteForce.boj_1476;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception {
        String[] input = br.readLine().split(" ");
        int E = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);
        int year = 1;

        int countE = 1;
        int countS = 1;
        int countM = 1;

        while (true) {
            if (countE >= 16) countE = 1;
            if (countS >= 29) countS = 1;
            if (countM >= 20) countM = 1;
            if (countE == E && countS == S && countM == M) break;

            countE++;
            countS++;
            countM++;
            year++;

        }
        bw.write(year + "");
        bw.flush();
        bw.close();
    }
}
