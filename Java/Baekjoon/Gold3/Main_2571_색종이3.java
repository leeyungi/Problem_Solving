package Java.Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2571_색종이3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        final int SIZE = 100;
        int N = Integer.parseInt(br.readLine()), max = 0;
        int map[][] = new int[SIZE + 1][SIZE + 1];

        for (int i = 0; i < N; i++) {
            int left, down;
            st = new StringTokenizer(br.readLine());
            left = Integer.parseInt(st.nextToken());
            down = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= 10; j++) {
                for (int k = 1; k <= 10; k++) {
                    map[down + j][left + k] = 1;
                }
            }
        }

        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                if (map[i][j] != 0) map[i][j] = map[i][j - 1] + 1;
            }
        }

        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                if (map[i][j] == 0) continue;
                int value = 0;
                for (int k = i; k <= SIZE; k++) {
                    if (map[k][j] < map[i][j]) {
                        value += k - i;
                        break;
                    }
                    if (k == SIZE) value += k - i + 1;
                }
                for (int k = i; 1 <= k; k--) {
                    if (map[k][j] < map[i][j]) {
                        value += i - k;
                        break;
                    }
                    if (k == 1) value += i - k + 1;
                }
                max = Integer.max(max, map[i][j] * (value - 1));
            }
        }

        System.out.println(max);
    }
}
