package Java.Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_19942_다이어트 {
    static int N, mp, mf, ms, mv, nutrient[][], min;
    static String selected;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        nutrient = new int[N][5];

        st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());
        min = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                nutrient[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        subset(0, 0, 0, 0, 0, 0, 0);
        sb.append(min).append("\n");
        if (min != -1) {
            for (int i = selected.length() - 1; 0 <= i; i--) {
                if (selected.charAt(i) == '1') sb.append(selected.length() - i).append(" ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void subset(int i, int p, int f, int s, int v, int sum, int flag) {
        if (mp <= p && mf <= f && ms <= s && mv <= v) {
            if (min == -1 || sum < min) {
                min = sum;
                selected = Integer.toBinaryString(flag);
            }
            return;
        }
        if (i == N || (0 <= min && min <= sum)) return;

        subset(i + 1, p + nutrient[i][0], f + nutrient[i][1] , s + nutrient[i][2], v + nutrient[i][3], sum + nutrient[i][4], flag | 1 << i);
        subset(i + 1, p, f, s, v, sum, ~(~flag | 1 << i));
    }
}
