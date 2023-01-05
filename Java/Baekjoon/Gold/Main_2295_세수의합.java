package Java.Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main_2295_세수의합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N, num[];
        Set<Integer> sum_set = new TreeSet<>();
        ArrayList<Integer> sum_list;

        N = Integer.parseInt(br.readLine());
        num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sum_set.add(num[i] + num[j]);
            }
        }

        sum_list = new ArrayList<>(sum_set);
        for (int i = N - 1; 0 <= i; i--) {
            for (int j = i; 0 <= j; j--) {
                int n = num[i] - num[j];
                int left = 0, right = sum_list.size() - 1;
                while (left <= right) {
                    int mid = sum_list.get((right + left) / 2);
                    if (n == mid) {
                        bw.write(String.valueOf(num[i]));
                        bw.flush();
                        bw.close();
                        return;
                    }
                    else if (n < mid) right = (right + left) / 2 - 1;
                    else left = (right + left) / 2 + 1;
                }
            }
        }
    }
}
