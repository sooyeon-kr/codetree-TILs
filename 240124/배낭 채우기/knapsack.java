import java.io.*;
import java.util.*;

public class Main {
    static final int INT_MIN = -1;
    static final int MN = 105;
    static final int MM = 10005;
    static int N, M;    
    static int[] w = new int[MN];
    static int[] v = new int[MN];
    static int[][] dp = new int[MM][MN];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; ++i){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<MM; ++i) Arrays.fill(dp[i], INT_MIN);
        dp[0][0] = 0;

        for(int i=1; i<=N; ++i){
            for(int j=0; j<=M; ++j){
                if(j >= w[i]){
                    dp[j][i] = Math.max(dp[j-w[i]][i-1] + v[i], dp[j][i-1]);
                }else{
                    dp[j][i] = dp[j][i-1];
                }
            }
        }

        int ans = 0;
        for(int i=0; i<=M; ++i)
            ans = Math.max(ans, dp[i][N]);
    
        System.out.println(ans);
    }
}