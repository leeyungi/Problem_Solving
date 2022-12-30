package Java.Baekjoon.Gold;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2141_우체국 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N;
        long people_sum = 0, answer = 0;
        PriorityQueue<village> queue = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long point, people;
            point = Integer.parseInt(st.nextToken());
            people = Integer.parseInt(st.nextToken());
            queue.offer(new village(point, people));
            people_sum += people;
        }

        long people_temp = 0;
        for (int i = 0; i < N; i++) {
            village v = queue.poll();
            people_temp += v.people;
            if ((people_sum + 1) / 2 <= people_temp) {
                answer = v.point;
                break;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}

class village implements Comparable<village>{
    long point, people;

    village(long point, long people) {
        this.point = point;
        this.people = people;
    }

    @Override
    public int compareTo(village o) {
        if (this.point - o.point < 0) return -1;
        else if (this.point - o.point > 0) return 1;
        else return 0;
    }
}
