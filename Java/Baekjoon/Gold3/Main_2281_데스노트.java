package Java.Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2281_데스노트 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N, M, name[], dp[];

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        name = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            name[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; 0 < i; i--) {
            int len = name[i];
            dp[i] = (M - len) * (M - len) + dp[i + 1];
            for (int j = i + 1; j <= N; j++) {
                if (M < len + name[j] + 1) break;
                if (j == N) dp[i] = 0;
                else {
                    len += name[j] + 1;
                    dp[i] = Integer.min(dp[i], (M - len) * (M - len) + dp[j + 1]);
                }
            }
        }

        bw.write(String.valueOf(dp[1]));
        bw.flush();
        bw.close();
    }
}
