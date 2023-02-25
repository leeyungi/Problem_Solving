package Java.Baekjoon.Gold2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21757_나누기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N, sum[], dp_small[], dp_big[];
        long answer;
        N = Integer.parseInt(br.readLine());

        sum = new int[N + 1];
        dp_small = new int[N + 1];
        dp_big = new int[N + 1];
        answer = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }
        if (sum[N] % 4 != 0) {
            System.out.println(0);
            return;
        }
        for (int i = 2; i <= N - 2; i++) {
            dp_small[i] = dp_small[i - 1];
            if (sum[i - 1] == sum[N] / 4) dp_small[i]++;
        }
        for (int i = N - 2; 2 <= i; i--) {
            dp_big[i] = dp_big[i + 1];
            if (sum[i + 1] == (sum[N] / 4) * 3) dp_big[i]++;
        }
        for (int i = 2; i <= N - 2; i++) {
            if (sum[i] == sum[N] / 2) answer += (long) dp_small[i] * (long) dp_big[i];
        }
        System.out.println(answer);
    }
}