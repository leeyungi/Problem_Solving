package Java.Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2248_이진수찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N, L;
        long I, dp[][];
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        I = Long.parseLong(st.nextToken());
        dp = new long[N + 1][L + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= L; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        for (int i = N; 0 < i; i--) {
            int sum = 0;
            for (int j = 0; j <= L; j++) {
                sum += dp[i - 1][j];
            }
            if (sum < I) {
                sb.append(1);
                I -= sum;
                L--;
            }
            else sb.append(0);
        }
        System.out.print(sb.toString());
    }
}