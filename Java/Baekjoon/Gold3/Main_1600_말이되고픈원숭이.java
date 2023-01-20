package Java.Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {
    static int K, W, H, map[][];
    static int monkey_row[] = {0, 0, 1, -1}, monkey_col[] = {1, -1, 0, 0};
    static int horse_row[] = {1, 1, -1, -1, 2, 2, -2, -2}, horse_col[] = {2, -2, 2, -2, 1, -1, 1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (H == 1 && W == 1) bw.write("0");
        else bw.write(String.valueOf(bfs()));
        bw.flush();
        bw.close();
    }

    static int bfs() {
        Queue<node_1600> queue = new LinkedList<>();
        boolean visit[][][] = new boolean[H][W][K + 1];
        queue.offer(new node_1600(0, 0, K, 0));
        visit[0][0][K] = true;

        while (!queue.isEmpty()) {
            node_1600 n = queue.poll();

            for (int i = 0; i < 4; i++) {
                int r = n.row + monkey_row[i], c = n.col + monkey_col[i];
                if (r < 0 || c < 0 || H <= r || W <= c || map[r][c] == 1 || visit[r][c][n.horse]) continue;
                if (r == H - 1 && c == W - 1) return n.count + 1;
                queue.offer(new node_1600(r, c, n.horse, n.count + 1));
                visit[r][c][n.horse] = true;
            }
            if (n.horse == 0) continue;
            for (int i = 0; i < 8; i++) {
                int r = n.row + horse_row[i], c = n.col + horse_col[i];
                if (r < 0 || c < 0 || H <= r || W <= c || map[r][c] == 1 || visit[r][c][n.horse - 1]) continue;
                if (r == H - 1 && c == W - 1) return n.count + 1;
                queue.offer(new node_1600(r, c, n.horse - 1, n.count + 1));
                visit[r][c][n.horse - 1] = true;
            }
        }
        return -1;
    }
}

class node_1600 {
    int row, col, horse, count;
    node_1600(int row, int col, int horse, int count) {
        this.row = row;
        this.col = col;
        this.horse = horse;
        this.count = count;
    }
}