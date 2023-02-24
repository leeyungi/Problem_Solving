package Java.Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14395_4연산 {
    static final int MAX_MULTI = 31622, MAX_ADD = 500000000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s, t;
        String answer;
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        if (s == t) answer = "0";
        else if (t == 1) answer = "/";
        else answer = bfs(s, t);
        System.out.println(answer);
    }

    static String bfs(int s, int t) {
        Queue<info_14395> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        if (s <= MAX_MULTI){
            queue.add(new info_14395(s * s, "*"));
            set.add(s * s);
        }
        if (s <= MAX_ADD) {
            queue.add(new info_14395(s + s, "+"));
            set.add(s + s);
        }
        queue.add(new info_14395(1, "/"));
        set.add(1);

        while (!queue.isEmpty()) {
            info_14395 info = queue.poll();

            if (info.num == t) return info.answer;
            if (info.num <= MAX_MULTI && !set.contains(info.num * info.num)) {
                queue.offer(new info_14395(info.num * info.num, info.answer + "*"));
                set.add(info.num * info.num);
            }
            if (info.num <= MAX_ADD && !set.contains(info.num + info.num)) {
                queue.offer(new info_14395(info.num + info.num, info.answer + "+"));
                set.add(info.num + info.num);
            }
        }

        return "-1";
    }
}

class info_14395 {
    int num;
    String answer;

    info_14395(int num, String answer) {
        this.num = num;
        this.answer = answer;
    }
}
