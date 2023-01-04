package Java.Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15662_톱니바퀴2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int T, K, answer = 0;
        ArrayList<Integer> list[];

        T = Integer.parseInt(br.readLine());
        list = new ArrayList[T];
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            list[i] = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                list[i].add(s.charAt(j) - '0');
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num, turn[] = new int[T];
            num = Integer.parseInt(st.nextToken()) - 1;
            turn[num] = Integer.parseInt(st.nextToken());

            for (int j = num; j < T - 1; j++) {
                if (list[j].get(2) != list[j + 1].get(6)) turn[j + 1] = turn[j] * -1;
                else break;
            }

            for (int j = num; 0 < j; j--) {
                if (list[j].get(6) != list[j - 1].get(2)) turn[j - 1] = turn[j] * -1;
                else break;
            }

            for (int j = 0; j < T; j++) {
                if (turn[j] == -1) list[j].add(list[j].remove(0));
                else if (turn[j] == 1) list[j].add(0, list[j].remove(7));
            }
        }

        for (int i = 0; i < T; i++) {
            answer += list[i].get(0);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
