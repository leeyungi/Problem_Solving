package Java.Baekjoon.Gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int V, E, K, distance[];
        boolean visit[];
        ArrayList<node_1753> list[];

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine()) - 1;
        distance = new int[V];
        visit = new boolean[V];
        list = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            list[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A, B, C;
            A = Integer.parseInt(st.nextToken()) - 1;
            B = Integer.parseInt(st.nextToken()) - 1;
            C = Integer.parseInt(st.nextToken());
            list[A].add(new node_1753(B, C));
        }

        PriorityQueue<node_1753> queue = new PriorityQueue<>();
        queue.offer(new node_1753(K, 0));
        distance[K] = 0;
        while (!queue.isEmpty()) {
            node_1753 n = queue.poll();
            if (visit[n.num]) continue;
            visit[n.num] = true;
            for (node_1753 node : list[n.num]) {
                if (visit[node.num]) continue;
                if (n.value + node.value < distance[node.num]) distance[node.num] = n.value + node.value;
                queue.offer(new node_1753(node.num, distance[node.num]));
            }
        }
        for (int i = 0; i < V; i++) {
            if (distance[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(distance[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
class node_1753 implements Comparable<node_1753>{
    int num, value;
    node_1753(int num, int value) {
        this.num = num;
        this.value = value;
    }

    @Override
    public int compareTo(node_1753 n) {
        return this.value - n.value;
    }
}
