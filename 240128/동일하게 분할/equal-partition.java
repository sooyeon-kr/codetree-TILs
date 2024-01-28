import java.io.*;
import java.util.*;

public class Main {
    static final int MN = 105;
    static final int MM = 100005;
    static int N;

    static int[] nums = new int[MN];
    static boolean[][] dp = new boolean[MN][MM];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; ++i){
            nums[i] = Integer.parseInt(st.nextToken());
            sum += nums[i];
        }

        dp[0][0] = true;
        for(int i=1; i<=N; ++i){
            for(int j=1; j<=sum; ++j){
                if(j-nums[i]>=0 && dp[i-1][j-nums[i]]){
                    dp[i][j] = true;
                }
                if(dp[i-1][j]){
                    dp[i][j] = true;
                }
            }
        }
        // System.out.println(Arrays.toString(dp[N]));
        if(sum % 2 == 1 || dp[N][sum/2]==false){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
	
    }
}