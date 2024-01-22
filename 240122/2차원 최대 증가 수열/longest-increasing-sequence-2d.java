import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];
        for(int y=0; y<N; ++y){
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<M; ++x){
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;

        dp[0][0] = 1;
        for(int y=0; y<N; ++y){
            for(int x=0; x<M; ++x){
                dp[y][x] = findMaxNum(arr[y][x], y, x);
                ans = Math.max(ans, dp[y][x]);
            }
        }


        System.out.println(ans);
    
    }

    static int findMaxNum(int max, int Y, int X){
        if(Y==0 && X==0)
            return 1;

        int ret = 0;

        for(int y=0; y<Y; ++y){
            for(int x=0; x<X; ++x){
                if(dp[y][x]==0) continue;
                if(arr[y][x] >= max) continue;
                ret = Math.max(ret, dp[y][x]+1);
            }
        }

        return ret;
    }

}