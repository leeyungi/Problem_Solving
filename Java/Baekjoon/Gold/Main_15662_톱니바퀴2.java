package Java.Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15662_톱니바퀴2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int T, K, answer = 0;
        int gear[][];

        T = Integer.parseInt(br.readLine());
        gear = new int[T][8];
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = (s.charAt(j) - '0');
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num, turn[] = new int[T];
            num = Integer.parseInt(st.nextToken()) - 1;
            turn[num] = Integer.parseInt(st.nextToken());

            for (int j = num; j < T - 1; j++) {
                if (gear[j][2] != gear[j + 1][6]) turn[j + 1] = turn[j] * -1;
                else break;
            }

            for (int j = num; 0 < j; j--) {
                if (gear[j][6] != gear[j - 1][2]) turn[j - 1] = turn[j] * -1;
                else break;
            }

            for (int j = 0; j < T; j++) {
                if (turn[j] == -1) {
                    int temp = gear[j][0];
                    for (int k = 0; k < 7; k++) {
                        gear[j][k] = gear[j][k + 1];
                    }
                    gear[j][7] = temp;
                }
                else if (turn[j] == 1) {
                    int temp = gear[j][7];
                    for (int k = 7; 0 < k; k--) {
                        gear[j][k] = gear[j][k - 1];
                    }
                    gear[j][0] = temp;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            answer += gear[i][0];
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
