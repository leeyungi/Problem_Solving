package Java.Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2823_유턴싫어 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int R, C, answer, d_row[] = {1, -1, 0, 0}, d_col[] = {0, 0, 1, -1};
        char map[][];
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        answer = 0;
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        OUT : for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') continue;
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int r = i + d_row[k], c = j + d_col[k];
                    if (r < 0 || c < 0 || R <= r || C <= c || map[r][c] == 'X') continue;
                    count++;
                }
                if (count < 2) {
                    answer = 1;
                    break OUT;
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
