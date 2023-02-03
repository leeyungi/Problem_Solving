package Java.Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {
    static int W, H, map[][], count;
    static int d_row[] = {0, 0, 1, -1, 1, -1, 1, -1}, d_col[] = {1, -1, 0, 0, 1, -1, -1, 1};
    static boolean visit[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        while (true) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            if (W == 0 && H == 0) break;

            map = new int[H][W];
            count = 0;
            visit = new boolean[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (visit[i][j] || map[i][j] == 0) continue;
                    dfs(i, j);
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void dfs(int row, int col) {
        Stack<node_4963> stack = new Stack<>();
        stack.push(new node_4963(row, col));
        visit[row][col] = true;

        while (!stack.isEmpty()) {
            node_4963 n = stack.pop();

            for (int i = 0; i < 8; i++) {
                int r = n.row + d_row[i], c = n.col + d_col[i];
                if (c < 0 || r < 0 || H <= r || W <= c || visit[r][c] || map[r][c] == 0) continue;
                stack.push(new node_4963(r, c));
                visit[r][c] = true;
            }
        }
    }
}

class node_4963 {
    int row, col;
    node_4963(int row, int col) {
        this.row = row;
        this.col = col;
    }
}