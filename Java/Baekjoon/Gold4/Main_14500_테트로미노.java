package Java.Baekjoon.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N, M, max, map[][];
        int shape[][][] = {
                {{0, 1}, {0, 2}, {0, 3}},
                {{1, 0}, {2, 0}, {3, 0}},
                {{0, 1}, {1, 0}, {1, 1}},
                {{0, 1}, {-1, 0}, {-2, 0}},
                {{1, 0}, {0, 1}, {0, 2}},
                {{0, -1}, {1, 0}, {2, 0}},
                {{-1, 0}, {0, -1}, {0, -2}},
                {{-1, 0}, {0, 1}, {1, 1}},
                {{0, 1}, {1, 0}, {1, -1}},
                {{-1, 0}, {0, -1}, {0, 1}},
                {{0, 1}, {1, 0}, {-1, 0}},
                {{1, 0}, {0, 1}, {0, -1}},
                {{0, -1}, {-1, 0}, {1, 0}},
                {{0, -1}, {-1, 0}, {-2, 0}},
                {{-1, 0}, {0, 1}, {0, 2}},
                {{0, 1}, {1, 0}, {2, 0}},
                {{1, 0}, {0, -1}, {0, -2}},
                {{-1, 0}, {0, -1}, {1, -1}},
                {{0, -1}, {1, 0}, {1, 1}}
        };

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = 0;
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 19; k++) {
                    int sum = map[i][j];
                    for (int q = 0; q < 3; q++) {
                        int r = i + shape[k][q][0], c = j + shape[k][q][1];
                        if (r < 0 || c < 0 || N <= r || M <= c) {
                            sum = 0;
                            break;
                        }
                        sum += map[r][c];
                    }
                    max = Integer.max(max, sum);
                }
            }
        }
        System.out.println(max);
    }
}