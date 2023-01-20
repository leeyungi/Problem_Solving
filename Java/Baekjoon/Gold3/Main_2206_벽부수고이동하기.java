package Java.Baekjoon.Gold;

import java.io.*;
import java.util.*;

public class Main_2206_벽부수고이동하기 {
    static int N, M, map[][];
    static int drow[] = {1, -1, 0, 0}, dcol[] = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        if (N == 1 && M == 1) bw.write("1");
        else bw.write(String.valueOf(bfs()));
        bw.flush();
        bw.close();
    }

    static int bfs() {
        int min = Integer.MAX_VALUE;

        Queue<node_2206> queue = new LinkedList<>();
        boolean visit[][][] = new boolean[N][M][2];
        queue.offer(new node_2206(0, 0, 1, false));

        while (!queue.isEmpty()) {
            node_2206 n = queue.poll();

            for (int i = 0; i < 4; i++) {
                int r, c;
                r = n.row + drow[i];
                c = n.col + dcol[i];

                if (r < 0 || c < 0 || N <= r || M <= c) continue;
                if (n.used) {
                    if (map[r][c] == 1 || visit[r][c][1]) continue;
                    if (r == N - 1 && c == M - 1) return n.count + 1;
                    queue.offer(new node_2206(r, c, n.count + 1, true));
                    visit[r][c][1] = true;
                }
                else {
                    if (map[r][c] == 1) {
                        if (visit[r][c][1]) continue;
                        queue.offer(new node_2206(r, c, n.count + 1, true));
                        visit[r][c][1] = true;
                    }
                    else {
                        if (visit[r][c][0]) continue;
                        if (r == N - 1 && c == M - 1) return n.count + 1;
                        queue.offer(new node_2206(r, c, n.count + 1, false));
                        visit[r][c][0] = true;
                    }
                }

            }
        }
        return -1;
    }
}

class node_2206 {
    int row, col, count;
    boolean used;
    node_2206(int row, int col, int count, boolean used) {
        this.row = row;
        this.col = col;
        this.count = count;
        this.used = used;
    }
}