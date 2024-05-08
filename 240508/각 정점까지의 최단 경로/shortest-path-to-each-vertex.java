/*
정점 n개, 간선 m개 
무방향
1~n번
k번 정점에서 다른 모든 정점으로 가는 최단 경로,
Mlov(N) => 10^5 * 4 * 3

*/

import java.util.*;
import java.io.*;
public class Main {
    static class Node{
        int idx, dist;
        Node(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }
    }
    static class Element implements Comparable<Element>{
        int idx, dist;
        Element(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }
        @Override
        public int compareTo(Element e){
            return this.dist - e.dist;
        }
    }
    static final int INF = (int)1e8;
    static int N, M, K;
    static int[] dist;
    static ArrayList<Node>[] graph;
    static PriorityQueue<Element> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(br.readLine());

        dist = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=0; i<N+1; ++i) graph[i] = new ArrayList<>();
        Arrays.fill(dist, INF);
        dist[K] = 0;

        for(int i=0; i<M; ++i){
            input=br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int d = Integer.parseInt(input[2]);
            
            graph[s].add(new Node(e, d));
            graph[e].add(new Node(s, d));
        }


        pq.add(new Element(K, 0));
        while(!pq.isEmpty()){
            Element cur = pq.poll();
            if(dist[cur.idx] != cur.dist) continue;

            for(Node nx:graph[cur.idx]){
                int nxIdx = nx.idx;
                int nxDist = nx.dist;
                
                int newDist = dist[cur.idx] + nxDist;
                if(dist[nxIdx] <= newDist) continue;
                dist[nxIdx] = newDist;
                pq.offer(new Element(nxIdx, dist[nxIdx]));
            }        
        }

        for(int i=1; i<N+1; ++i){
            sb.append(dist[i]==INF?-1:dist[i]).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
        br.close();

    }
}