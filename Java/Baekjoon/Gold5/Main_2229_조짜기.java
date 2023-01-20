package Java.Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2229_조짜기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N, score[], dp[];
        N = Integer.parseInt(br.readLine());
        score = new int[N + 1];
        dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        dp[2] = Math.abs(score[1] - score[2]);
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1];
            for (int j = 2; j <= i; j++) {
                dp[i] = Integer.max(dp[i], dp[i - j] + Math.abs(score[i] - score[i - j + 1]));
            }
        }

        bw.write(String.valueOf(dp[N]));
        bw.flush();
        bw.close();
    }
}
