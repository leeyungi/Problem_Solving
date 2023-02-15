package Java.Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2800_괄호제거 {

    static String s;
    static int match[];
    static boolean select[];
    static Set<String> set = new TreeSet<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        s = br.readLine();
        int size = 0, right_count = 0, left_count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') size++;
        }
        match = new int[size];
        select = new boolean[size];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(right_count);
                right_count++;
            }
            else if (s.charAt(i) == ')') {
                match[left_count] = stack.pop();
                left_count++;
            }
        }
        subset("", 0, 0, 0);
        Iterator<String> print = set.iterator();
        print.next();
        while (print.hasNext()) {
            sb.append(print.next()).append("\n");
        }
        System.out.print(sb.toString());
    }
    static void subset(String temp, int i, int right_index, int left_index) {
        if (i == s.length()) {
            set.add(temp);
            return;
        }

        if (s.charAt(i) == '(') {
            select[right_index] = true;
            subset(temp + String.valueOf(s.charAt(i)), i + 1, right_index + 1, left_index);

            select[right_index] = false;
            subset(temp, i + 1, right_index + 1, left_index);
        }
        else if (s.charAt(i) == ')') {
            if (!select[match[left_index]]) subset(temp, i + 1, right_index, left_index + 1);
            else subset(temp + String.valueOf(s.charAt(i)), i + 1, right_index, left_index + 1);
        }
        else subset(temp + String.valueOf(s.charAt(i)), i + 1, right_index, left_index);
    }
}