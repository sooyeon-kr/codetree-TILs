import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static int[] dp;
    static int[] rdp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        dp = new int[N];
        rdp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i)
            nums[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; ++i){
            dp[i] = 1;
            for(int j=0; j<i; ++j){
                if(nums[i] <= nums[j]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        for(int i=N-1; i>=0; --i){
            rdp[i] = 1;
            for(int j=N-1; i<j; --j){
                if(nums[i] <= nums[j]) continue;
                rdp[i] = Math.max(rdp[i], rdp[j] + 1);
            }
        }
        int ans = 0;
        for(int i=0; i<N; ++i){
            int left = dp[i];
            int right = 0; 
            for(int j=i+1; j<N; ++j){
                if(nums[i] < nums[j]) continue;
                right = Math.max(right, dp[j]);
            }
            left += right;
            ans = Math.max(ans, left);
        }
        // System.out.println(Arrays.toString(rdp));
        System.out.println(ans);
    }


}