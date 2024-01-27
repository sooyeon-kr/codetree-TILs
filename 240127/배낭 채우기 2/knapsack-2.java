import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] weights;
    static int[] values;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        weights = new int[N+1];
        values = new int[N+1];
        dp = new int[M+1];

        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i=1; i<=N; ++i){
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=M; ++i){
            for(int j=1; j<=N; ++j){
                if(i-weights[j]<0 || dp[i-weights[j]]==-1) continue;
                dp[i] = Math.max(dp[i-weights[j]]+values[j], dp[i]);
            }
        }
    // System.out.println(Arrays.toString(dp));
    int ans = 0;
    for(int i=1; i<=M; ++i){
        ans = Math.max(dp[i], ans);
    }

    System.out.println(ans);

        
	
    }
}