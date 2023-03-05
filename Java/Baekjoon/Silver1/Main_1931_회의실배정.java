package Java.Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1931_회의실배정 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine()), answer = 1;
        meeting_1931 meeting[] = new meeting_1931[N];

        for (int i = 0; i < N; i++) {
            int start, end;
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            meeting[i] = new meeting_1931(start, end);
        }
        Arrays.sort(meeting);
        int end = meeting[0].end;
        for (int i = 1; i < N; i++) {
            if (meeting[i].start < end) continue;
            end = meeting[i].end;
            answer++;
        }

        System.out.println(answer);
    }
}

class meeting_1931 implements Comparable<meeting_1931>{
    int start, end;
    meeting_1931(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(meeting_1931 o) {
        if (this.end != o.end) return this.end - o.end;
        else return this.start - o.start;
    }
}