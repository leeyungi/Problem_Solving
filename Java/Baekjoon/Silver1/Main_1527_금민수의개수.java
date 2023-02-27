package Java.Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1527_금민수의개수 {
    static int A, B, answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        answer = 0;
        dfs(0);
        System.out.println(answer);
    }

    static void dfs(long num) {
        if (B < num) return;

        if (A <= num && num <= B) answer++;
        dfs(num * 10 + 4);
        dfs(num * 10 + 7);
    }
}
