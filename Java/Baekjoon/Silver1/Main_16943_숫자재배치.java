package Java.Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_16943_숫자재배치 {
    static int num[], answer, max;
    static String A, B;
    static boolean use[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = st.nextToken();
        B = st.nextToken();
        if (B.length() < A.length()) {
            System.out.println(-1);
            return;
        }
        max = Integer.parseInt(B);
        num = new int[A.length()];
        use = new boolean[A.length()];
        answer = -1;
        for (int i = 0; i < A.length(); i++) {
            num[i] = A.charAt(i) - '0';
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int index, int temp) {
        if (index == A.length()) {
            if (temp < max && answer < temp) answer = temp;
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (use[i]) continue;
            if (index == 0 && num[i] == 0) continue;
            use[i] = true;
            dfs(index + 1, temp * 10 + num[i]);
            use[i] = false;
        }
    }
}
