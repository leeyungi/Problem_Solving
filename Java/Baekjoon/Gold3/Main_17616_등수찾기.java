package Java.Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17616_등수찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, M, X;
        ArrayList<Integer> up[], down[];
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        up = new ArrayList[N + 1];
        down = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            up[i] = new ArrayList<>();
            down[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int A, B;
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            down[A].add(B);
            up[B].add(A);
        }

        int up_count = 1, down_count = N;
        Queue<Integer> queue = new LinkedList<>();
        boolean visit[] = new boolean[N + 1];
        queue.add(X);
        visit[X] = true;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int i = 0; i < up[n].size(); i++) {
                if (visit[up[n].get(i)]) continue;
                queue.add(up[n].get(i));
                visit[up[n].get(i)] = true;
                up_count++;
            }
        }

        visit = new boolean[N + 1];
        queue.add(X);
        visit[X] = true;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int i = 0; i < down[n].size(); i++) {
                if (visit[down[n].get(i)]) continue;
                queue.add(down[n].get(i));
                visit[down[n].get(i)] = true;
                down_count--;
            }
        }

        System.out.println(up_count + " " + down_count);
    }
}
