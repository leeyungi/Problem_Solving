package Java.Baekjoon.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9663_NQueen {
    static int N, row[], answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        row = new int[N];
        answer = 0;
        back_tracking(0);
        System.out.println(answer);
    }

    static void back_tracking(int col) {
        if (col == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            int j;
            for (j = 0; j < col; j++) {
                if (row[j] == i || col - j == Math.abs(row[j] - i)) break;
            }
            if (j == col) {
                row[col] = i;
                back_tracking(col + 1);
            }
        }
    }
}
