import java.io.*;
import java.util.*;

public class Main {
    static final int MN = 105;
    static int[] red = new int[MN*2], blue = new int[MN*2];
    static int N;
    static int[][] dp = new int[MN*2][MN];
    static int ans = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        red = new int[N*2+2];
        blue = new int[N*2+2];
        for(int i=1; i<=2*N; ++i){
            String[] input = br.readLine().split(" ");
            red[i] = Integer.parseInt(input[0]);
            blue[i] = Integer.parseInt(input[1]);
        }

        dp[0][0] = 0;
        for(int i=1; i<=2*N; ++i){
            for(int j=0; j<=i; ++j){
                // 빨강 카드 선택
                if(j > 0){
                    dp[i][j] = Math.max(dp[i-1][j-1]+red[i], dp[i][j]);
                }

                if(i - j > 0){
                    dp[i][j] = Math.max(dp[i-1][j]+blue[i], dp[i][j]);
                }
            }
        }

        ans = dp[2*N][N];
        // for(int i=0; i<=2*N; ++i){
        //     for(int j=0; j<=2*N; ++j){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        System.out.println(ans);
    }
}