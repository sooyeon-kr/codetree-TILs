import java.io.*;
import java.util.*;

public class Main {
    static final int INT_MIN = -(int)1e4;
    static int N, M;
    static int[] nums;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        dp = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i)
            nums[i] = Integer.parseInt(st.nextToken());

        Arrays.fill(dp, INT_MIN);
        dp[0] = 0;
        for(int j=0; j<N; ++j){
            for(int i=M; i>0; --i){
                if(i < nums[j] || dp[i-nums[j]]==INT_MIN) continue;
                dp[i] = Math.max(dp[i-nums[j]]+1, dp[i]);
            }
        }
        
        String ans = dp[M] == INT_MIN ? "No" : "Yes";

        System.out.println(ans);
        
	
    }
}