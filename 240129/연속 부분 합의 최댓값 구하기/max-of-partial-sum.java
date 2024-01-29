import java.io.*;
import java.util.*;

public class Main {
    static final int M_V = -(int)1e7, MN = 100005;
    static int N, ans=M_V;
    static int[] nums = new int[MN];
    static int[] dp = new int[MN];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i)
            nums[i] = Integer.parseInt(st.nextToken());
        
        dp[0] = nums[0];
        ans = dp[0];
        for(int i=1; i<N; ++i){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);

	
    }
}