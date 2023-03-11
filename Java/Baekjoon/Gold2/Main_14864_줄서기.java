package Java.Baekjoon.Gold2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_14864_줄서기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N, M, count[], sort[];
        LinkedList<Integer> number = new LinkedList<>();
        ArrayList<Integer> bigger[];

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        count = new int[N];
        sort = new int[N];
        bigger = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            number.add(i + 1);
            bigger[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            count[a - 1]++;
            bigger[b - 1].add(a - 1);
        }

        OUT : for (int i = 0; i < N; i++) {
            int answer = -1;
            if (number.size() < count[i]) {
                sb = new StringBuilder();
                sb.append(-1);
                break;
            }
            for (int j = 0; j < bigger[i].size(); j++) {
                if (sort[bigger[i].get(j)] < number.get(count[i])) {
                    sb = new StringBuilder();
                    sb.append(-1);
                    break OUT;
                }
            }
            sort[i] = number.get(count[i]);
            sb.append(sort[i] + " ");
            number.remove(count[i]);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
