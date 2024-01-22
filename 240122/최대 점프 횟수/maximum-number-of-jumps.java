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
        nums = new int[N + 5];
        dp = new int[N + 5];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; ++i)
            nums[i] = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<=N; ++i){
            for(int j=1; j<i; ++j){
                if(j+nums[j] >= i){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for(int i=1; i<=N; ++i)
            ans = Math.max(ans, dp[i]);

        System.out.println(ans);

    }
}