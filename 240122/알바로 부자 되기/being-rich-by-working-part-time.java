import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] sTime;
    static int[] eTime;
    static int[] coins;
    static int[] dp;
    static int ans = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());    
        sTime = new int[N];
        eTime = new int[N];
        coins = new int[N];
        dp = new int[N];

        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            sTime[i] = Integer.parseInt(st.nextToken());
            eTime[i] = Integer.parseInt(st.nextToken());
            coins[i] = Integer.parseInt(st.nextToken());
            dp[i] = coins[i]; 
        }

        for(int i=1; i<N; ++i){
            for(int j=0; j<i; ++j){
                if(eTime[j] < sTime[i]){
                    dp[i] = Math.max(dp[i], dp[j] + coins[i]);
                }
            }
        }
        int ans = 0;
        for(int i=0; i<N; ++i)
            ans = Math.max(ans, dp[i]);

        
        // System.out.println(Arrays.toString(dp));
        System.out.println(ans);
	
    }
}