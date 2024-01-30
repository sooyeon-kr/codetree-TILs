import java.io.*;
import java.util.*;

public class Main {
    static final int INF = (int)1e6;
    static int N;
    static int[] nums;
    static int[][] dp;
    static int ans = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][4];
        nums = new int[N+1];
        String[] str = br.readLine().split(" ");
        for(int i=1; i<=N; ++i) nums[i] = Integer.parseInt(str[i-1]);

        dp[1][0] = -INF;
        dp[1][2] = -INF;
        dp[1][3] = -INF;

        dp[2][1] = -INF;
        dp[2][3] = -INF;


        dp[1][1] = nums[1];
        dp[2][0] = nums[2];
        dp[2][2] = nums[1]+nums[2];
        
        for(int i=3; i<=N; ++i){
            for(int j=0; j<4; ++j){
                dp[i][j] = Math.max(dp[i][j], dp[i-2][j] + nums[i]);
                if(j > 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+nums[i]);
            }
        }
        for(int i=0; i<4; ++i){
            ans = Math.max(ans, dp[N][i]);
        }
        System.out.println(ans);
    }
}