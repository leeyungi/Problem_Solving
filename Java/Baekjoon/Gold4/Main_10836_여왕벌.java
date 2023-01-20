package Java.Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10836_여왕벌 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N, M, map[][], sum[];
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][M];
        sum = new int[2 * M - 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int zero, one, two;
            zero = Integer.parseInt(st.nextToken());
            one = Integer.parseInt(st.nextToken());
            two = Integer.parseInt(st.nextToken());
            if (zero != 2 * M - 1) sum[zero]++;
            if (two != 0) sum[zero + one]++;
        }

        int index = 0, value = 1;
        for (int i = M - 1; 0 < i; i--) {
            value += sum[index];
            map[i][0] = value;
            index++;
        }

        for (int i = 0; i < M; i++) {
            value += sum[index];
            map[0][i] = value;
            index++;
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (i != 0 && j != 0) map[i][j] = Integer.max(map[i - 1][j - 1], Integer.max(map[i - 1][j], map[i][j - 1]));
                bw.write(String.valueOf(map[i][j] + " "));
            }
            if (i != M - 1) bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
