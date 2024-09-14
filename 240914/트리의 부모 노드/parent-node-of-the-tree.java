import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Integer>[] edge = new ArrayList[n+1];
        for(int i=0; i<=n; ++i) edge[i] = new ArrayList<>();
        int[] parent = new int[n+1];
        boolean[] visit = new boolean[n+1];

        for(int i=1; i<n; ++i){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            edge[a].add(b);
            edge[b].add(a);
        }
        
        visit[1] = true;
        traversal(1, edge, visit, parent);

        for(int i=2; i<=n; ++i){
            System.out.println(parent[i]);
        }
    }

    static void traversal(int node, List<Integer>[] edge, boolean[] visit, int[] parent){
        for(int next:edge[node]){
            if(visit[next]) continue;
            visit[next] = true;
            parent[next] = node;
            traversal(next, edge, visit, parent);
        }
    }

    
}