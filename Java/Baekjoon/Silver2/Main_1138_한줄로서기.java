package Java.Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1138_한줄로서기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N, taller[], num[];
        N = Integer.parseInt(br.readLine());
        taller = new int[N];
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            taller[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int index = 0, count = 0;
            while (count != taller[i]) {
                if (num[index] == 0) count++;
                index++;
            }
            while (num[index] != 0) index++;
            num[index] = i + 1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(num[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
