package Java.Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15922_아우으우아으이야 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N, sum, before_xy[];
        N = Integer.parseInt(br.readLine());
        sum = 0;
        before_xy = new int[2];

        for (int i = 0; i < N; i++) {
            int x, y;
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if (i == 0) {
                before_xy[0] = x;
                before_xy[1] = y;
            }
            else {
                if (before_xy[1] < x) {
                    sum += before_xy[1] - before_xy[0];
                    before_xy[0] = x;
                    before_xy[1] = y;
                }
                else if (before_xy[1] < y) before_xy[1] = y;
            }
        }
        sum += before_xy[1] - before_xy[0];

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
