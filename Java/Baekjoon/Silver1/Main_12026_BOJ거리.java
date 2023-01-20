package Java.Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_12026_BOJ거리 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N, DP[];
        String street;

        N = Integer.parseInt(br.readLine());
        DP = new int[N + 1];
        street = br.readLine();
        DP[N] = -1;
        for (int i = 0; i < N; i++) {
            char now_alp = street.charAt(i);
            for (int j = i + 1; j < N; j++) {
                char next_alp = street.charAt(j);

                if (now_alp == 'B' && next_alp != 'O') continue;
                else if (now_alp == 'O' && next_alp != 'J') continue;
                else if (now_alp == 'J' && next_alp != 'B') continue;
                else if (i != 0 && DP[i + 1] == 0) continue;

                int value = DP[i + 1] + (i - j) * (i - j);
                if (DP[j + 1] == 0 || DP[j + 1] == -1) DP[j + 1] = value;
                else DP[j + 1] = Math.min(DP[j + 1], value);
            }
        }
        bw.write(String.valueOf(DP[N]));
        bw.flush();
        bw.close();
    }
}
