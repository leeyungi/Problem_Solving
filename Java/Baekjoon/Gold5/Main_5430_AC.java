package Java.Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5430_AC {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T, N;
        String order, array[];

        T = Integer.parseInt(br.readLine());
        OUT : while (0 < T--) {
            boolean reverse = false;
            String temp;
            order = br.readLine();
            N = Integer.parseInt(br.readLine());
            int front = 0, back = N;
            temp = br.readLine();
            temp = temp.replace("[", "");
            temp = temp.replace("]", "");
            array = temp.split(",");

            for (int i = 0; i < order.length(); i++) {
                char c = order.charAt(i);
                if (c == 'R') reverse = !reverse;
                else if (N <= front + (N - back)) {
                    sb.append("error").append("\n");
                    continue OUT;
                }
                else if (reverse) back--;
                else front++;
            }
            sb.append("[");
            if (!reverse) {
                for (int i = front; i < back; i++) {
                    sb.append(array[i]);
                    if (i != back - 1) sb.append(",");
                }
            }
            else {
                for (int i = back - 1; front <= i; i--) {
                    sb.append(array[i]);
                    if (i != front) sb.append(",");
                }
            }
            sb.append("]\n");
        }
        System.out.print(sb.toString());
    }
}
