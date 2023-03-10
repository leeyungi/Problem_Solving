package Java.Baekjoon.Gold2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2461_대표선수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, M, skill[][], max = 0, answer = Integer.MAX_VALUE;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        skill = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                skill[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            Arrays.sort(skill[i]);
        }

        PriorityQueue<array_2461> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.offer(new array_2461(i, 0, skill[i][0]));
            max = Integer.max(max, skill[i][0]);
        }

        while (true) {
            array_2461 a = queue.poll();
            answer = Integer.min(answer, max - a.value);
            if (a.M == M - 1) break;
            max = Integer.max(max, skill[a.N][a.M + 1]);
            queue.offer(new array_2461(a.N, a.M + 1, skill[a.N][a.M + 1]));
        }
        System.out.println(answer);
    }
}

class array_2461 implements Comparable<array_2461>{
    int N, M, value;
    array_2461(int N, int M, int value) {
        this.N = N;
        this.M = M;
        this.value = value;
    }

    public int compareTo(array_2461 o) {
        return this.value - o.value;
    }
}
