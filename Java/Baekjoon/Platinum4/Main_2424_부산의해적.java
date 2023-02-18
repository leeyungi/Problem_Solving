package Java.Baekjoon.Platinum4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2424_부산의해적 {
    static char map[][];
    static int N, M, see_map[][], pirate_map[][], d_row[] = {0, 0, 1, -1, 0}, d_col[] = {1, -1, 0, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        see_map = new int[N][M];
        pirate_map = new int[N][M];

        int s_row = 0, s_col = 0, p_row = 0, p_col = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                see_map[i][j] = Integer.MAX_VALUE;
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'Y') {
                    s_row = i;
                    s_col = j;
                }
                if (map[i][j] == 'V') {
                    p_row = i;
                    p_col = j;
                }
            }
        }
        fill_count_map(p_row, p_col);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'I') {
                    min = Integer.MAX_VALUE;
                    continue;
                }
                else min = Integer.min(min, pirate_map[i][j]);
                see_map[i][j] = Integer.min(min, see_map[i][j]);
            }
            min = Integer.MAX_VALUE;
            for (int j = M - 1; 0 <= j; j--) {
                if (map[i][j] == 'I') {
                    min = Integer.MAX_VALUE;
                    continue;
                }
                else min = Integer.min(min, pirate_map[i][j]);
                see_map[i][j] = Integer.min(min, see_map[i][j]);
            }
        }
        for (int j = 0; j < M; j++) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                if (map[i][j] == 'I') {
                    min = Integer.MAX_VALUE;
                    continue;
                }
                else min = Integer.min(min, pirate_map[i][j]);
                see_map[i][j] = Integer.min(min, see_map[i][j]);
            }
            min = Integer.MAX_VALUE;
            for (int i = N - 1; 0 <= i; i--) {
                if (map[i][j] == 'I') {
                    min = Integer.MAX_VALUE;
                    continue;
                }
                else min = Integer.min(min, pirate_map[i][j]);
                see_map[i][j] = Integer.min(min, see_map[i][j]);
            }
        }

        System.out.println(sua_move(s_row, s_col));
    }

    static void fill_count_map(int row, int col) {
        Queue<node_2424> queue = new LinkedList<>();
        boolean visit[][] = new boolean[N][M];
        queue.offer(new node_2424(row, col, 0));
        visit[row][col] = true;

        while (!queue.isEmpty()) {
            node_2424 n = queue.poll();
            pirate_map[n.row][n.col] = n.count;

            for (int i = 0; i < 4; i++) {
                int r = n.row + d_row[i], c = n.col + d_col[i];
                if (r < 0 || c < 0 || N <= r || M <= c || visit[r][c] || map[r][c] == 'I') continue;
                queue.offer(new node_2424(r, c, n.count + 1));
                visit[r][c] = true;
            }
        }
    }

    static String sua_move(int row, int col) {
        Queue<node_2424> queue = new LinkedList<>();
        boolean visit[][] = new boolean[N][M];
        queue.offer(new node_2424(row, col, 0));
        visit[row][col] = true;

        while (!queue.isEmpty()) {
            node_2424 n = queue.poll();

            for (int i = 0; i < 4; i++) {
                int r = n.row + d_row[i], c = n.col + d_col[i];
                if (r < 0 || c < 0 || N <= r || M <= c || visit[r][c] || map[r][c] == 'I' || see_map[r][c] <= n.count + 1) continue;
                if (map[r][c] == 'T') return "YES";
                queue.offer(new node_2424(r, c, n.count + 1));
                visit[r][c] = true;
            }
        }
        return "NO";
    }
}

class node_2424 {
    int row, col, count;
    node_2424(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }
}
