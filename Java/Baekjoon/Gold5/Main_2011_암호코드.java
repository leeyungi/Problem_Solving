package Java.Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2011_암호코드 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num = br.readLine();
        int N, dp[];
        N = num.length();
        dp = new int[N];

        if (num.charAt(0) != '0') {
            dp[0] = 1;
            for (int i = 1; i < N; i++) {
                int ten, one;
                ten = (num.charAt(i - 1) -'0') * 10;
                one = num.charAt(i) - '0';
                if (1 <= one && one <= 9) {
                    if (i == 1) dp[i]++;
                    else dp[i] += dp[i - 1];
                }
                if (10 <= ten + one && ten + one <= 26) {
                    if (i == 1) dp[i]++;
                    else dp[i] += dp[i - 2];
                }
                dp[i] %= 1000000;
                if (dp[i] == 0) break;
            }
        }

        bw.write(String.valueOf(dp[N - 1]));
        bw.flush();
        bw.close();
    }
}
