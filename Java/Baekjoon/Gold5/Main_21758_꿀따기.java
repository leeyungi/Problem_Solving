package Java.Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_21758_꿀따기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N, num[], left[], right[], r2, l2, r1l1;

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        left = new int[N];
        right = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        left[0] = num[0];
        right[N - 1] = num[N - 1];

        for (int i = 1; i < N; i++) {
            left[i] = left[i - 1] + num[i];
            right[N - 1 - i] = right[N - i] + num[N - 1 - i];
        }

        l2 = 0;
        r2 = 0;
        r1l1 = 0;
        for (int i = 1; i < N; i++) {
            if (1 < i) {
                int sum = left[i] - left[0] + num[i] - num[i - 1];
                if (l2 + (num[i] * 2) < sum) l2 = sum;
                else l2 += num[i] * 2;

                sum = right[N - 1 - i] - right[N - 1] + num[N - 1 - i] - num[N - i];
                if (r2 + (num[N - 1 - i] * 2) < sum) r2 = sum;
                else r2 += num[N - 1 - i] * 2;
            }
            if (i < N - 1) {
                int sum = left[i] - left[0] + right[i] - right[N - 1];
                if (r1l1 < sum) r1l1 = sum;
            }
        }

        int answer = Math.max(Math.max(r2, l2), r1l1);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}

