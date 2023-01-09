package Java.Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_16936_나3곱2 {
    static int N;
    static long num[];
    static ArrayList<Long> odd, even;
    static boolean find;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int odd_count = 0, even_count = 0;
        N = Integer.parseInt(br.readLine());
        num = new long[N];
        odd = new ArrayList<>();
        even = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(st.nextToken());
            if (num[i] % 2 == 0) even.add(num[i]);
            else odd.add(num[i]);
        }

        odd.sort(Comparator.reverseOrder());
        for (int i = 0; i < odd.size(); i++) {
            num[i] = odd.get(i);
        }

        if (even.size() != 0) {
            OUT : for (int i = 0; i < even.size(); i++) {
                long temp1 = 0, temp2;
                if (even.get(i) % 3 == 0) temp1 = even.get(i) / 3;
                temp2 = even.get(i) * 2;
                for (int j = 0; j < even.size(); j++) {
                    if (even.get(j) == temp1 || even.get(j) == temp2) break;
                    if (j == even.size() - 1) {
                        fill_even(N - 1, even.get(i));
                        break OUT;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(String.valueOf(num[i] + " "));
        }
        bw.flush();
        bw.close();
    }

    static void fill_even(int index, long start_num) {
        if (find) return;

        num[index] = start_num;
        if (odd.size() == index) {
            find = true;
            return;
        }
        long temp = start_num * 3;
        for (int i = 0; i < even.size(); i++) {
            if (temp == even.get(i)) {
                fill_even(index - 1, temp);
                break;
            }
        }
        if (find) return;
        temp = start_num / 2;
        for (int i = 0; i < even.size(); i++) {
            if (temp == even.get(i)) {
                fill_even(index - 1, temp);
                break;
            }
        }
    }
}
