package Java.Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15810_풍선공장 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        final long MAX = 1000000000000l;
        int N, M, time[];

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        time = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        long left = 1, right = MAX, mid = (left + right) / 2, answer = MAX;

        while (left <= right) {
            long count = 0;
            for (int i = 0; i < N; i++) {
                count += mid / time[i];
                if (M <= count) break;
            }
            if (M <= count) {
                answer = Long.min(answer, mid);
                right = mid - 1;
            }
            else left = mid + 1;
            mid = (left + right) / 2;
        }
        System.out.println(answer);
    }
}
