package Java.Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
    static int N, M, D, map[][], d_row[] = {0, -1, 0}, d_col[] = {-1, 0, 1}, max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M - 2; i++) {
            for (int j = i + 1; j < M - 1; j++) {
                for (int k = j + 1; k < M; k++) {
                    shoot(new int[]{i, j, k});
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    static void shoot(int shooter[]) {
        int enemy_die[][] = new int[N][M];
        int temp_N = N, die_count = 0;
        while (temp_N > 0) {

            for (int i = 0; i < 3; i++) {
                int row = temp_N - 1, col = shooter[i];
                if (map[row][col] == 1) {
                    if (enemy_die[row][col] == 0) {
                        die_count++;
                        enemy_die[row][col] = temp_N;
                        continue;
                    }
                    if (enemy_die[row][col] == temp_N) continue;
                }
                Queue<node_17135> queue = new LinkedList<>();
                boolean visit[][] = new boolean[N][M];
                queue.offer(new node_17135(row, col, 1));
                visit[row][col] = true;

                OUT : while (!queue.isEmpty()) {
                    node_17135 n = queue.poll();
                    for (int j = 0; j < 3; j++) {
                        int r = n.row + d_row[j], c = n.col + d_col[j];
                        if (r < 0 || c < 0 || N <= r || M <= c || visit[r][c] || n.distance == D) continue;
                        if (map[r][c] == 1) {
                            if (enemy_die[r][c] == 0) {
                                die_count++;
                                enemy_die[r][c] = temp_N;
                                break OUT;
                            }
                            if (enemy_die[r][c] == temp_N) break OUT;
                        }
                        queue.offer(new node_17135(r, c, n.distance + 1));
                        visit[r][c] = true;
                    }
                }
            }
            temp_N--;
        }
        max = Integer.max(max, die_count);
    }
}

class node_17135 {
    int row, col, distance;
    node_17135(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}