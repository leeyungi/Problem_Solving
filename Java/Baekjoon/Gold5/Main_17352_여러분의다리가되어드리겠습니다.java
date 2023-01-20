package Java.Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main_17352_여러분의다리가되어드리겠습니다 {
    static int parents[];
    static ArrayList<Integer> bridge[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N;

        N = Integer.parseInt(br.readLine());
        parents = new int[N];
        bridge = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            parents[i] = i;
            bridge[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b;
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            bridge[a].add(b);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < bridge[i].size(); j++) {
                union(i, bridge[i].get(j));
            }
        }

        for (int i = 0; i < N - 1; i++) {
            int a, b;
            a = find(i);
            b = find(i + 1);
            if (a == b) continue;
            sb.append(a + 1).append(" ").append(b + 1);
            break;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int find(int a) {
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b) {
        parents[find(a)] = parents[find(b)];
    }
}
