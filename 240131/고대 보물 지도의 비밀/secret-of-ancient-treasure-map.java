import java.io.*;
import java.util.*;

public class Main {
    static final int MN = 100005;
    static final int INF = -(int)1e7;
    static int N, K;
    static int[] a = new int[MN];
    static int[][] dp = new int[MN][15];
    static int ans = INF;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        for(int i=1; i<=N; ++i){
            a[i] = Integer.parseInt(input[i-1]);
        }

        for(int i=1; i<=N; ++i){
            if(a[i] >=0 ){
                for(int k=0; k<=K; ++k){
                    dp[i][k] = Math.max(dp[i-1][k] + a[i], dp[i][k]);
                    ans = Math.max(ans, dp[i][k]);
                }
            }else{
                for(int k=1; k<=K; ++k){
                    dp[i][k] = Math.max(dp[i-1][k-1] + a[i], dp[i][k]);
                    ans = Math.max(ans, dp[i][k]);
                }
            }
        }

        System.out.println(ans);


    }
}