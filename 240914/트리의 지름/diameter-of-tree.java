import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dist1;
    static boolean[] visit1;
    static int[] dist2;
    static boolean[] visit2;
    static class Edge{
        int node;
        int dist;
        Edge(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    static ArrayList<Edge>[] edge;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        dist1 = new int[N+1];
        dist2 = new int[N+1];
        visit1 = new boolean[N+1];
        visit2 = new boolean[N+1];
        edge = new ArrayList[N+1];
        for(int i=0; i<N+1; ++i) edge[i] = new ArrayList<>();
        for(int i=0; i<N-1; ++i){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int dist = Integer.parseInt(input[2]);
            edge[a].add(new Edge(b, dist));
            edge[b].add(new Edge(a, dist));
        }
        visit1[1] = true;
        dist1[1] = 0;
        findMaxDist(1, dist1, visit1);
        int maxDistNode = 1;
        int maxDist = 0;
        for(int i=1; i<N+1; ++i){
            if(maxDist < dist1[i]){
                maxDist=dist1[i];
                maxDistNode=i;
            }
        }
        visit2[maxDistNode] = true;
        dist2[maxDistNode] = 0;
        findMaxDist(maxDistNode, dist2, visit2);
        maxDist = 0;
        for(int i=1; i<N+1; ++i){
            if(maxDist < dist2[i]){
                maxDist = dist2[i];
            }
        }
        System.out.println(maxDist);
    }
    static void findMaxDist(int node, int[] dist, boolean[] visit){
        for(Edge next: edge[node]){
            if(visit[next.node]) continue;
            visit[next.node] = true;
            dist[next.node] = next.dist + dist[node];
            findMaxDist(next.node, dist, visit);
        }
    }
}