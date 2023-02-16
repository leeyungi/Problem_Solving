package Java.Baekjoon.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1563_개근상 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int DIVIDE = 1000000;
        int N;
        long dp[][], answer = 0;
        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][2];

        dp[1][0] = 1;
        dp[1][1] = 1;
        if (2 <= N) {
            dp[2][0] = 2;
            dp[2][1] = 2;
        }

        for (int i = 3; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] + dp[i - 2][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][0] %= DIVIDE;
            dp[i][1] %= DIVIDE;
        }
        answer = dp[N][0] + dp[N][1];
        answer %= DIVIDE;

        for (int i = 1; i <= N; i++) {
            if (i == N) answer += dp[i][1];
            else answer += dp[i][1] * (dp[N - i][0] + dp[N - i][1]);
            answer %= DIVIDE;
        }
        System.out.println(answer);
    }
}