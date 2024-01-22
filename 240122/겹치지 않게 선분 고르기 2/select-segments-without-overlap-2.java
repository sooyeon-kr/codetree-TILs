import java.io.*;
import java.util.*;

class Line implements Comparable<Line>{
    int s, e;
    Line(int s, int e){
        this.s = s;
        this.e = e;
    }
    @Override
    public int compareTo(Line l){
        if(this.e == l.e) return this.s - l.s;
        return this.e - l.e;
    }
}
public class Main {
    static int N;
    static PriorityQueue<Line> pq = new PriorityQueue<>();
    static int ans = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Line(s, e));
        }

        ans = 1;
        Line prev = pq.poll();
        while(!pq.isEmpty()){
            Line cur = pq.poll();
            if(prev.e < cur.s) ++ans;
            prev = cur;
        }

        System.out.println(ans);
    
    }
}