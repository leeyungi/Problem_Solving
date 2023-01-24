package Java.Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_12781_PIZZAALVOLOC {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x[], y[];

        x = new int[4];
        y = new int[4];

        for (int i = 0; i < 4; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 3; 0 <= i; i--) {
            x[i] -= x[0];
            y[i] -= y[0];
        }

        if ((x[0] - x[1]) * y[2] < (y[0] - y[1]) * x[2] && (x[0] - x[1]) * y[3] > (y[0] - y[1]) * x[3]) bw.write("1");
        else if ((x[0] - x[1]) * y[2] > (y[0] - y[1]) * x[2] && (x[0] - x[1]) * y[3] < (y[0] - y[1]) * x[3]) bw.write("1");
        else bw.write("0");

        bw.flush();
        bw.close();
    }
}
