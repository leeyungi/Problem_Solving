package Java.Baekjoon.Gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1707_이분그래프 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int K, V, E;
        node_1707[] node;
        K = Integer.parseInt(br.readLine());

        while (0 < K--) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            node = new node_1707[V];
            for (int i = 0; i < V; i++) {
                node[i] = new node_1707(0, new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int A, B;
                A = Integer.parseInt(st.nextToken()) - 1;
                B = Integer.parseInt(st.nextToken()) - 1;

                node[A].list.add(B);
                node[B].list.add(A);
            }

            Queue<node_1707> queue = new LinkedList<>();
            node[0].where = 1;
            queue.offer(node[0]);

            OUT : while (true) {
                if (queue.isEmpty()) {
                    for (int i = 0; i < V; i++) {
                        if (node[i].where == 0) {
                            node[i].where = 1;
                            queue.offer(node[i]);
                            break;
                        }
                        if (i == V - 1) {
                            sb.append("YES").append("\n");
                            break OUT;
                        }
                    }
                }
                node_1707 n = queue.poll();
                for (int i = 0; i < n.list.size(); i++) {
                    int num = n.list.get(i);
                    if (node[num].where == 0) {
                        node[num].where = n.where * -1;
                        queue.offer(node[num]);
                    }
                    else if (node[num].where * n.where != -1) {
                        sb.append("NO").append("\n");
                        break OUT;
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

class node_1707 {
    int where;
    ArrayList<Integer> list;

    node_1707(int where, ArrayList<Integer> list) {
        this.where = where;
        this.list = list;
    }
}
