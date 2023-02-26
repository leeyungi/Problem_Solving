package Java.Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14248_점프점프 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N, rock[], start, count;

        N = Integer.parseInt(br.readLine());
        rock = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            rock[i] = Integer.parseInt(st.nextToken());
        }
        start = Integer.parseInt(br.readLine());
        count = 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean visit[] = new boolean[N + 1];

        queue.offer(start);
        visit[start] = true;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            count++;
            if (1 <= num - rock[num] && !visit[num - rock[num]]) {
                queue.offer(num - rock[num]);
                visit[num - rock[num]] = true;
            }
            if (num + rock[num] <= N && !visit[num + rock[num]]) {
                queue.offer(num + rock[num]);
                visit[num + rock[num]] = true;
            }
        }
        System.out.println(count);
    }
}