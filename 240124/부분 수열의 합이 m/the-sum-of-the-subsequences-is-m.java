import java.io.*;
import java.util.*;

public class Main {
    static final int INT_MAX = (int)1e4;
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
        dp = new int[M+5];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i)
            nums[i] = Integer.parseInt(st.nextToken());

        Arrays.fill(dp, INT_MAX);
        dp[0] = 0;
        Arrays.sort(nums);
        for(int i=0; i<N; ++i){
            for(int j=M; j>0; --j){
                if(j-nums[i] < 0) continue;
                dp[j] = Math.min(dp[j], dp[j-nums[i]]+1);
            }
        }
        int ans = -1;
        if(dp[M]!=INT_MAX) ans = dp[M];
        System.out.println(ans);
    }
}