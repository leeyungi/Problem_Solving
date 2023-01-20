package Java.Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2550_전구 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N, num1[], num2[], switch_bulb[], before[], dp[], size;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        N = Integer.parseInt(br.readLine());
        num1 = new int[N];
        num2 = new int[N];
        switch_bulb = new int[N];
        before = new int[N];
        dp = new int[N];
        size = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken()) - 1;
            num1[n] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken()) - 1;
            num2[i] = n;
            switch_bulb[num1[num2[i]]] = i;
        }

        dp[0] = switch_bulb[0];

        for (int i = 1; i < N; i++) {
            int num = switch_bulb[i];
            if (dp[size] < num) {
                before[num] = dp[size];
                size++;
                dp[size] = num;
                continue;
            }

            int left = 0, right = size;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (dp[mid] < num) {
                    if (num < dp[mid + 1]) {
                        before[num] = dp[mid];
                        dp[mid + 1] = num;
                        break;
                    }
                    left = mid + 1;
                }
                else if (num < dp[mid]) {
                    if (mid == 0 || dp[mid - 1] < num) {
                        if (0 < mid) before[num] = dp[mid - 1];
                        dp[mid] = num;
                        break;
                    }
                    right = mid - 1;
                }
            }
        }

        for (int i = size; 0 < i; i--) {
            dp[i - 1] = before[dp[i]];
            queue.offer(num2[dp[i]] + 1);
        }
        queue.offer(num2[dp[0]] + 1);
        sb.append(size + 1).append("\n");
        for (int i = 0; i <= size; i++) {
            sb.append(queue.poll()).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

