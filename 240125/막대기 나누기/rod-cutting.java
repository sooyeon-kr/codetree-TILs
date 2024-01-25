import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] profit;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        profit = new int[N];
        dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i)
            profit[i] = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N; ++i){
            for(int j=1; j<=i; ++j){
                dp[j] = Math.max(dp[j], dp[j-(i+1)]+profit[i]);
            }
        }
        // System.out.println(Arrays.toString(dp));

        System.out.println(dp[N]);

    }
}