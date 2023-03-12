package Java.Baekjoon.Gold1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_23290_마법사상어와복제 {
    static int M, S, s_x, s_y, max_fish, shark_road[][];
    static int small_map[][], fish_map[][][], moved_fish_map[][][], fish_count_map[][];
    static int f_row[] = {0, -1, -1, -1, 0, 1, 1, 1}, f_col[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int s_row[] = {-1, 0, 1, 0}, s_col[] = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        shark_road = new int[3][2];
        small_map = new int[4][4];
        fish_count_map = new int[4][4];
        fish_map = new int[4][4][8];

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r, c, d;
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            d = Integer.parseInt(st.nextToken()) - 1;

            fish_map[r][c][d]++;
            fish_count_map[r][c]++;
        }

        st = new StringTokenizer(br.readLine());
        s_x = Integer.parseInt(st.nextToken()) - 1;
        s_y = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < S; i++) {
            max_fish = -1;
            move_fish();

            int temp_road[][] = new int[3][2];
            move_shark(s_x, s_y,0, 0, temp_road);

            copy_fish();
        }
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                answer += fish_count_map[i][j];
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    static void move_fish() {
        moved_fish_map = new int[4][4][8];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 8; k++) {
                    int r, c, d;
                    d = k;
                    for (int t = 0; t < 8; t++) {
                        r = i + f_row[d];
                        c = j + f_col[d];
                        if (0 <= r && 0 <= c && r < 4 && c < 4 && small_map[r][c] == 0 && !(r == s_x && c == s_y)) {
                            moved_fish_map[r][c][d] += fish_map[i][j][k];
                            fish_count_map[r][c] += fish_map[i][j][k];
                            fish_count_map[i][j] -= fish_map[i][j][k];
                            break;
                        }
                        if (d == 0) d = 7;
                        else d--;
                        if (t == 7) moved_fish_map[i][j][k] += fish_map[i][j][k];
                    }
                }
            }
        }
    }
    static void move_shark(int row, int col, int move, int eat_fish, int[][] temp_road) {
        if (move == 3) {
            if (max_fish < eat_fish) {
                s_x = row;
                s_y = col;
                for (int i = 0; i < 3; i++) {
                    shark_road[i][0] = temp_road[i][0];
                    shark_road[i][1] = temp_road[i][1];
                }
                max_fish = eat_fish;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int r, c;
            r = row + s_row[i];
            c = col + s_col[i];
            if (r < 0 || c < 0 || 4 <= r || 4 <= c) continue;
            temp_road[move][0] = r;
            temp_road[move][1] = c;
            int fish_count = fish_count_map[r][c];
            fish_count_map[r][c] = 0;
            move_shark(r, c, move + 1, eat_fish + fish_count, temp_road);
            fish_count_map[r][c] = fish_count;
        }
    }

    static void copy_fish() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (0 < small_map[i][j]) small_map[i][j]--;
            }
        }

        for (int i = 0; i < 3; i++) {
            int r, c;
            r = shark_road[i][0];
            c = shark_road[i][1];
            if (0 < fish_count_map[r][c]) {
                fish_count_map[r][c] = 0;
                moved_fish_map[r][c] = new int[8];
                small_map[r][c] = 2;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 8; k++) {
                    fish_count_map[i][j] += fish_map[i][j][k];
                    fish_map[i][j][k] += moved_fish_map[i][j][k];
                }
            }
        }
    }
}

