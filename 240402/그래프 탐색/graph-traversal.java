import java.io.*;
import java.util.*;

public class Main {
    static int vertexCnt = 0;
    public static void main(String[] args) throws Exception{
        // 여기에 코드를 작성해주세요.
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        ArrayList<Integer> graph[] = new ArrayList[N+1];
        for(int i=0; i<=N; ++i) graph[i] = new ArrayList<>();
        
        for(int i=0; i<M; ++i){
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            graph[s].add(e);
            graph[e].add(s);
        }
        boolean[] vis = new boolean[N+1];
         dfs(graph, vis, 1);
        System.out.println(vertexCnt);
    }

    static void dfs(ArrayList<Integer>[] graph, boolean[] vis, int v){
        vis[v] = true;
        for(int i=0; i<graph[v].size(); ++i){
            if(vis[graph[v].get(i)]==true) continue;
            vis[graph[v].get(i)] = true;
            vertexCnt++;
            dfs(graph, vis, graph[v].get(i));

        }
    }
}