package Java.Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_19583_싸이버개강총회 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String start_live, end_live, end_system;
        int count;
        Set<String> name = new HashSet<>();
        start_live = st.nextToken();
        end_live = st.nextToken();
        end_system = st.nextToken();
        count = 0;

        while (br.ready()) {
            String chatting[] = br.readLine().split(" ");

            if (chatting[0].compareTo(start_live) <= 0) name.add(chatting[1]);
            if (chatting[0].compareTo(end_live) >= 0 && chatting[0].compareTo(end_system) <= 0 && name.contains(chatting[1])) {
                count++;
                name.remove(chatting[1]);
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
