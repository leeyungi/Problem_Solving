package Java.Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1058_친구 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, max;
        boolean friend[][];
        N = Integer.parseInt(br.readLine());
        friend = new boolean[N][N];
        max = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == 'Y') friend[i][j] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            Queue<Integer> queue_friend = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                if (friend[i][j]) queue_friend.add(j);
            }
            boolean visit[] = new boolean[N];
            int count = 0;
            while (!queue_friend.isEmpty()) {
                int temp = queue_friend.poll();
                if(!visit[temp]) {
                    count++;
                    visit[temp] = true;
                }
                for (int j = 0; j < N; j++) {
                    if (i == j || visit[j] || !friend[temp][j]) continue;
                    count++;
                    visit[j] = true;
                }
            }
            max = Integer.max(max, count);
        }

        System.out.println(max);
    }
}
