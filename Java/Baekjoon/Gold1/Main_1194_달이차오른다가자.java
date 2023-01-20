package Java.Baekjoon.Gold1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자 {
    static int N, M, d_row[] = {0, 0, 1, -1}, d_col[] = {1, -1, 0, 0}, min = -1;
    static char map[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        int row = 0, col = 0;
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == '0') {
                    row = i;
                    col = j;
                }
            }
        }
        bfs(row, col);
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }

    static void bfs(int row, int col) {
        Queue<node_1194> queue = new LinkedList<>();
        boolean visit[][][] = new boolean[N][M][64];
        queue.offer(new node_1194(row, col, 0, 0));
        visit[row][col][0] = true;

        while (!queue.isEmpty()) {
            node_1194 n = queue.poll();

            for (int i = 0; i < 4; i++) {
                int r = n.row + d_row[i], c = n.col + d_col[i], d = n.distance + 1, k = n.key;
                if (r < 0 || c < 0 || N <= r || M <= c || map[r][c] == '#') continue;
                char load = map[r][c];
                if (load == '1') {
                    min = d;
                    return;
                }
                if ('A' <= load && load <= 'F' && (1 << (load - 'A') & k) != 1 << (load - 'A')) continue;
                if ('a' <= load && load <= 'f') k = k | 1 << (load - 'a');
                if (visit[r][c][k]) continue;
                queue.offer(new node_1194(r, c, d, k));
                visit[r][c][k] = true;
            }
        }
    }
}

class node_1194 {
    int row, col, distance, key;
    node_1194(int row, int col, int distance, int key) {
        this.row = row;
        this.col = col;
        this.distance = distance;
        this.key = key;
    }
}