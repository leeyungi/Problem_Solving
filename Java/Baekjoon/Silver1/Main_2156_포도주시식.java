package Java.Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2156_포도주시식 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, wine[], dp[][];
        N = Integer.parseInt(br.readLine());
        wine = new int[N + 1];
        dp = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        dp[1][1] = wine[1];
        if (1 < N) {
            dp[2][0] = wine[1];
            dp[2][1] = wine[1] + wine[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i][0] = Integer.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Integer.max(wine[i] + dp[i - 1][0], wine[i] + wine[i - 1] + dp[i - 2][0]);
        }
        System.out.println(Integer.max(dp[N][0], dp[N][1]));
    }
}
