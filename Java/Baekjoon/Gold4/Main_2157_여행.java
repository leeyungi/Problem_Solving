package Java.Baekjoon.Gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2157_여행 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N, M, K, node[][], dp[][], max;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        node = new int[N][N];
        dp = new int[N][M + 1];
        max = 0;

        for (int i = 0; i < K; i++) {
            int a, b, c;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken());
            if (b <= a) continue;
            node[a][b] = Integer.max(node[a][b], c);
        }

        for (int i = 1; i < N; i++) {
            dp[i][2] = node[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (node[j][i] == 0) continue;
                for (int k = 2; k <= M; k++) {
                    if (k == 2) dp[i][k] = node[0][i];
                    else if (dp[j][k - 1] != 0) dp[i][k] = Integer.max(dp[i][k], dp[j][k - 1] + node[j][i]);
                }
            }
        }

        for (int i = 2; i <= M; i++) {
            max = Integer.max(max, dp[N - 1][i]);
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
