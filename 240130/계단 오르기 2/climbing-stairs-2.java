import java.io.*;
import java.util.*;

public class Main {
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

        dp[1][1] = nums[1];
        for(int i=2; i<=N; ++i){
            dp[i][0] = dp[i-2][0] + nums[i];
            for(int j=1; j<4; ++j){
                dp[i][j] = Math.max(dp[i-1][j-1]+nums[i], dp[i-2][j]+nums[i]);
            }
        }
        for(int i=0; i<4; ++i){
            ans = Math.max(ans, dp[N][i]);
        }
        System.out.println(ans);
    }
}