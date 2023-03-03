package Java.Baekjoon.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2698_인접한비트의개수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        final int MAX_N = 100, MAX_K = 100;
        int dp[][][] = new int[MAX_N + 1][MAX_K + 1][2];

        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        for (int i = 2; i <= MAX_N; i++) {
            dp[i][0][0] = dp[i - 1][0][0] + dp[i - 1][0][1];
            dp[i][0][1] = dp[i - 1][0][0];
            for (int j = 1; j < i; j++) {
                dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
                dp[i][j][1] = dp[i - 1][j][0] + dp[i - 1][j - 1][1];
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n, k;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            sb.append(dp[n][k][0] + dp[n][k][1]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
