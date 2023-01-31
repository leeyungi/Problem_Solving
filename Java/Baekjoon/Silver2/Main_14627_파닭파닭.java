package Java.Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14627_파닭파닭 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S, C, pa[];
        long sum;
        S = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        pa = new int[S];
        sum = 0;
        for (int i = 0; i < S; i++) {
            pa[i] = Integer.parseInt(br.readLine());
            sum += pa[i];
        }

        int left = 1, right = 1000000000, mid = (left + right) / 2;
        while (left <= right) {
            int count = 0;
            for (int i = 0; i < S; i++) {
                count += pa[i] / mid;
            }
            if (C <= count) left = mid + 1;
            else right = mid - 1;
            mid = (left + right) / 2;
        }
        System.out.println(sum - ((long)C * (long)mid));
    }
}
