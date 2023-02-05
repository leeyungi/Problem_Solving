package Java.Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_22233_가희와키워드 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, M;
        Set<String> set = new HashSet<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        while (0 < N--) {
            set.add(br.readLine());
        }

        while (0 < M--) {
            String word[] = br.readLine().split(",");
            for (int i = 0; i < word.length; i++) {
                set.remove(word[i]);
            }
            sb.append(set.size()).append("\n");
        }
        System.out.print(sb.toString());
    }
}