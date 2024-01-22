import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] dp = new int[N+1];
        int[] nums = new int[N+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        nums[0] = 0;
        for(int i=0; i<N; ++i){
            nums[i+1] = Integer.parseInt(input[i]);
        }
        


        for(int i=1; i<=N; ++i){
            for(int j=0; j<i; ++j){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int res = 0;
        for(int i=0; i<=N; ++i){
            res = Math.max(dp[i], res);
        }

        System.out.println(res);
    }
}