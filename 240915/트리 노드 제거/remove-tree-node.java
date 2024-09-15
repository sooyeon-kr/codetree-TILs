import java.io.*;
import java.util.*;

public class Main {
    static int MN = 51;
    static int N;
    static ArrayList<Integer>[] edge = new ArrayList[MN];
    static int ans = 0;

    static int parentNode = 0;
    static boolean[] visit;
    static int dontGoNode;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        for(int i=0; i<N; ++i) edge[i] = new ArrayList<>();
        String[] input = br.readLine().split(" ");
        dontGoNode = Integer.parseInt(br.readLine());
        for(int child=0; child<N; ++child){
            int parent = Integer.parseInt(input[child]);
            if(parent==-1){
                parentNode = child;
                continue;
            }
            edge[parent].add(child);
        }
        if(parentNode != dontGoNode){
            visit[parentNode]=true;
            traversal(parentNode);
        }

        System.out.println(ans);
    }

    static void traversal(int node){
        if(edge[node].size()==1){
            ans++;
            return;
        }

        for(int next: edge[node]){
            if(visit[next]) continue;
            if(next == dontGoNode && edge[node].size() == 2){
                ans++;
                return;
            }
            visit[next] = true;
            traversal(next);
        }
    }

}

/*
리프노드라는건, 자식이 없다는 뜻
즉, 자신을 부모로 가진 노드가 없다.
0 1 2 3 4

-1 0 0 1 1

2 3 4

    0
   1. 2
  3.4

9
6 6 3 7 1 2 7 -1 1
2

        7    
    6.      3        
   0  1.    2         
     8 4.   5


1. 내려가서 연결된게 0개면
2. 
*/