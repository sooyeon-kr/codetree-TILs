import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int sum;
    static int[] nums;
    static boolean[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; ++i){
            nums[i] = Integer.parseInt(st.nextToken());
            sum += nums[i];
        }
        
        dp = new boolean[N+1][sum+1];
        dp[0][0] = true;
        for(int i=1; i<=N; ++i){
            for(int j=1; j<=sum; ++j){
                if(j - nums[i] >= 0 && dp[i-1][j-nums[i]]){
                    dp[i][j] = true;
                }
                if(dp[i-1][j]){
                    dp[i][j] = true;
                }
            }
        }
        int ans = (int)1e7;
        for(int i=1; i<=sum; ++i){
            if(dp[N][i])
                ans = Math.min(ans, Math.abs(i-(sum-i)));
        }

        System.out.println(ans);



	
    }
}