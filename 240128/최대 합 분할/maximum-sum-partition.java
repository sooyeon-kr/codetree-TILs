import java.io.*;
import java.util.*;

public class Main {
    static final int MN = 101;
    static final int MM = 100001;
    static int N;
    static int[] nums = new int[MN];
    static boolean[][] dp = new boolean[MN][MM];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int sum = 0;
        for(int i=1; i<=N; ++i){
            nums[i] = Integer.parseInt(st.nextToken());
            sum += nums[i];
        }

        dp[0][0] = true;
        for(int i=1; i<=N; ++i){
            for(int j=1; j<=sum; ++j){
                if(j >= nums[i] && dp[i-1][j-nums[i]]){
                    dp[i][j] = true;
                }
                if(dp[i-1][j]){
                    dp[i][j] = true;
                }
            }
        }

        int ans = 0;
        for(int i=sum>>>1; i>0; --i){
            if(dp[N][i] && dp[N][i*2]){
                ans = i;
                break;
            }
        }

        System.out.println(ans);



    }
}