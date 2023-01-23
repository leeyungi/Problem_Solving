package Java.Baekjoon.Platinum5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2568_전깃줄2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N, dp[], size, save_index[];
        node_2568 node[];

        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        save_index = new int[N];
        node = new node_2568[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 , n2;
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            node[i] = new node_2568(n1, n2);
        }
        Arrays.sort(node);

        dp[0] = node[0].B;
        size = 0;

        for (int i = 1; i < N; i++) {
            int num = node[i].B;
            if (dp[size] < num) {
                size++;
                dp[size] = num;
                save_index[i] = size;
                continue;
            }

            int left = 0, right = size;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (dp[mid] == num) break;
                if (dp[mid] < num) {
                    if (num < dp[mid + 1]) {
                        dp[mid + 1] = num;
                        save_index[i] = mid + 1;
                        break;
                    }
                    left = mid + 1;
                }
                else {
                    if (mid == 0 || dp[mid - 1] < num) {
                        dp[mid] = num;
                        save_index[i] = mid;
                        break;
                    }
                    right = mid - 1;
                }
            }
        }
        sb.append(N - (size + 1)).append("\n");
        boolean cut[] = new boolean[N];
        for (int i = N - 1; 0 <= i; i--) {
            if (save_index[i] != size) cut[i] = true;
            else size--;
        }
        for (int i = 0; i < N; i++) {
            if (cut[i]) sb.append(node[i].A).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
class node_2568 implements Comparable<node_2568>{
    int A, B;

    node_2568(int n1, int n2) {
        this.A = n1;
        this.B = n2;
    }

    @Override
    public int compareTo(node_2568 n) {
        return this.A - n.A;
    }
}


