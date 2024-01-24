import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] coins;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        coins = new int[N];
        dp = new int[M+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i)
            coins[i] = Integer.parseInt(st.nextToken());
        
        
        for(int i=1; i<=M; ++i){
            for(int j=0; j<N; ++j){
                if(i < coins[j]) continue;
                dp[i] = Math.max(dp[i], dp[i-coins[j]]+1);
            }
        }

        System.out.println(dp[M]);
	
    }
}