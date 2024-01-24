import java.io.*;
import java.util.*;

public class Main {
    static final int DIVISOR = 10007;
    static int N;
    static int[] dp;
    static int[] nums = {1, 2, 5};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        for(int i=0; i<3; ++i){
            dp[nums[i]] = 1;
        }
        for(int i=1; i<=N; ++i){
            for(int j=0; j<3; ++j){
                if(i < nums[j]) continue;
                dp[i] = (dp[i] + dp[i-nums[j]]) % DIVISOR;
            }
        }

        // System.out.println(Arrays.toString(dp));

        System.out.println(dp[N]);
        
    }
}