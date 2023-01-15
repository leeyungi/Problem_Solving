package Java.Baekjoon.Gold;

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

        if (num.charAt(0) != '0') dp[0] = 1;
        if (dp[0] != 0 && 1 < N) {
            if (num.charAt(0) == '1'){
                if (num.charAt(1) == '0') dp[1] = 1;
                else dp[1] = 2;
            }
            else if (num.charAt(0) == '2') {
                if (num.charAt(1) == '0' || '6' < num.charAt(1)) dp[1] = 1;
                else dp[1] = 2;
            }
            else if (num.charAt(1) != '0') dp[1] = 1;
        }

        for (int i = 2; i < N; i++) {
            int now, before = 0;
            now = num.charAt(i) - '0';
            before = num.charAt(i - 1) - '0';

            if (now == 0) {
                if (before != 1 && before != 2) break;
                dp[i] = dp[i - 2];
            }
            else if (before == 0){
                dp[i] = dp[i - 1];
            }
            else if (before == 1) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
            }
            else if (before == 2) {
                if (6 < now) dp[i] = dp[i - 1];
                else dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
            }
            else dp[i] = dp[i - 1];
        }

        bw.write(String.valueOf(dp[N - 1]));
        bw.flush();
        bw.close();
    }
}
