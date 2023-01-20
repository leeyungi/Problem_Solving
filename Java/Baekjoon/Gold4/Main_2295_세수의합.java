package Java.Baekjoon.Gold4;

import java.io.*;
import java.util.*;

public class Main_2295_세수의합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N, num[], sum[], count = 0;

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        sum = new int[N * N];

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sum[count++] = num[i] + num[j];
            }
        }
        Arrays.sort(sum, 0, count - 1);

        for (int i = N - 1; 0 <= i; i--) {
            for (int j = i; 0 <= j; j--) {
                if (Arrays.binarySearch(sum, 0, count - 1, num[i] - num[j]) < 0) continue;
                bw.write(String.valueOf(num[i]));
                bw.flush();
                bw.close();
                return;
            }
        }
    }
}
