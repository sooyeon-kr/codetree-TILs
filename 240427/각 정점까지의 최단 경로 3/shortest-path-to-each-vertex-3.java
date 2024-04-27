import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int node, dist;
    Node(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
    @Override
    public int compareTo(Node n){
        return this.dist - n.dist;
    }
}
public class Main {
    static final int INF = (int)1e9;
    static int N, M;
    static int[] dist= new int[105];
    static ArrayList<Node>[] graph = new ArrayList[105];
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        
        // 정점 개수, 간선 개수 입력 받기
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        // 인접리스트 초기화
        for(int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        // 간선 입력 받기 및 인접리스트에 저장
        for(int i=0; i<M; ++i){
            input = br.readLine().split(" ");
            int s =Integer.parseInt(input[0]);
            int e =Integer.parseInt(input[1]);
            int d =Integer.parseInt(input[2]);

            graph[s].add(new Node(e, d));
        }

        // dist값 모두 INF로 초기화
        for(int i=1; i<=N; ++i)
            dist[i] = INF;
        
        // 시작 위치 0으로 설정, pq에 삽입
        dist[1] = 0;
        pq.add(new Node(1, dist[1]));

        // 다익스트라
        while(!pq.isEmpty()){
            // 현재 가장 거리가 작은 노드
            Node cur = pq.poll();
            int curNode = cur.node;
            int curDist = cur.dist;

            if(dist[curNode] != curDist) continue;

            for(Node nx : graph[curNode]){
                int nxNode = nx.node;
                int nxDist = nx.dist;

                if(dist[nxNode] <= dist[curNode] + nxDist) continue;
                dist[nxNode] = dist[curNode] + nxDist;
                pq.add(new Node(nxNode, dist[nxNode]));
            }
        }

        for(int i=2; i<=N; ++i){
            sb.append(dist[i] != INF ? dist[i] : -1).append('\n');
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}