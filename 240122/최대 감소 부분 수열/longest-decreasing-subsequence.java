import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i)
            nums[i+1] = Integer.parseInt(st.nextToken());
        
        dp[0] = 0;
        for(int i=1; i<=N; ++i){
        	if(dp[i] == 0) dp[i] = 1;
            for(int j=1; j<i; ++j){
                if(nums[j] <= nums[i]) continue;
                dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int ans = 0;
        
        
        for(int i=0; i<=N; ++i)
            ans = Math.max(ans, dp[i]);

        System.out.println(ans);
    }
}