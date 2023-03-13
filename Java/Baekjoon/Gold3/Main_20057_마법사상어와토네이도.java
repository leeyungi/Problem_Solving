package Java.Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20057_마법사상어와토네이도 {
    static int N, send_map[][], d_row[] = {0, 1, 0, -1}, d_col[] = {-1, 0, 1, 0}, distance, answer;
    static boolean visit[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        send_map = new int[N][N];
        visit = new boolean[N][N];
        distance = 0;
        answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                send_map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tornado(N / 2, N / 2, 0);
        System.out.println(answer);
    }

    static void tornado(int r, int c, int d) {
        if (r == 0 && c == 0) return;

        visit[r][c] = true;
        int dr = d_row[d], dc = d_col[d], sum = 0;
        r += dr;
        c += dc;

        if (check_out(r + dr * 2, c + dc * 2)) send_map[r + dr * 2][c + dc * 2] += (send_map[r][c] * 5) / 100;
        else answer += (send_map[r][c] * 5) / 100;
        sum += (send_map[r][c] * 5) / 100;

        if (check_out(r + dc, c + dr)) send_map[r + dc][c + dr] += (send_map[r][c] * 7) / 100;
        else answer += (send_map[r][c] * 7) / 100;
        sum += (send_map[r][c] * 7) / 100;

        if (check_out(r + dc * 2, c + dr * 2)) send_map[r + dc * 2][c + dr * 2] += (send_map[r][c] * 2) / 100;
        else answer += (send_map[r][c] * 2) / 100;
        sum += (send_map[r][c] * 2) / 100;

        if (check_out(r - dc, c - dr)) send_map[r - dc][c - dr] += (send_map[r][c] * 7) / 100;
        else answer += (send_map[r][c] * 7) / 100;
        sum += (send_map[r][c] * 7) / 100;

        if (check_out(r - dc * 2, c - dr * 2)) send_map[r - dc * 2][c - dr * 2] += (send_map[r][c] * 2) / 100;
        else answer += (send_map[r][c] * 2) / 100;
        sum += (send_map[r][c] * 2) / 100;

        if (check_out(r + dr + dc, c + dc + dr)) send_map[r + dr + dc][c + dc + dr] += (send_map[r][c] * 10) / 100;
        else answer += (send_map[r][c] * 10) / 100;
        sum += (send_map[r][c] * 10) / 100;

        if (check_out(r + dr - dc, c + dc - dr)) send_map[r + dr - dc][c + dc - dr] += (send_map[r][c] * 10) / 100;
        else answer += (send_map[r][c] * 10) / 100;
        sum += (send_map[r][c] * 10) / 100;

        if (check_out(r - dr + dc, c - dc + dr)) send_map[r - dr + dc][c - dc + dr] += send_map[r][c] / 100;
        else answer += send_map[r][c] / 100;
        sum += send_map[r][c] / 100;

        if (check_out(r - dr - dc, c - dc - dr)) send_map[r - dr - dc][c - dc - dr] += send_map[r][c] / 100;
        else answer += send_map[r][c] / 100;
        sum += send_map[r][c] / 100;

        if (check_out(r + dr, c + dc)) send_map[r + dr][c + dc] += send_map[r][c] - sum;
        else answer += send_map[r][c] - sum;

        if (check_out(r + d_row[(d + 1) % 4], c + d_col[(d + 1) % 4]) && !visit[r + d_row[(d + 1) % 4]][c + d_col[(d + 1) % 4]]) tornado(r, c, (d + 1) % 4);
        else tornado(r, c, d);
    }

    static boolean check_out(int r, int c) {
        if (r < 0 || c < 0 || N <= r || N <= c) return false;
        else return true;
    }
}
