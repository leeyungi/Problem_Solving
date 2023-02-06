package Java.Baekjoon.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main_13701_중복제거 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        BitSet bitset = new BitSet();
        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            if (bitset.get(n)) continue;
            bitset.set(n);
            sb.append(n).append(" ");
        }
        System.out.print(sb.toString());
    }
}
