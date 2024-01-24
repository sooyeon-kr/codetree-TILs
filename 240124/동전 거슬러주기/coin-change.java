import java.io.*;
import java.util.*;

public class Main {
    static final int INF = (int)1e9;
    static int N, M; // 동전 종류 수와 거슬러 줄 금액
    static int[] coins; // 동전 종류별 금액
    static int[] dp; // idx원을 거슬러 줄 때, 필요한 최소 동전의 수 
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

// 초기화
        coins = new int[N]; 
        dp = new int[M+1]; 
        Arrays.fill(dp, INF);
        dp[0] = 0; // 0원을 거슬러 줄 때, 필요한 최소 동전의 수 = 0 

        st = new StringTokenizer(reader.readLine());
        for(int i=0; i<N; ++i){
            coins[i] = Integer.parseInt(st.nextToken());
        }  

        for(int i=1; i<=M; ++i){ // 1원부터 M원까지 
            for(int j=0; j<N; ++j){ // coins[0] ~ coins[N-1]까지 
                int prev = i - coins[j]; // i - coins[j] 원 => coins[j]원을 더하여 현재 금액을 만들기 전 
                if(prev < 0 || dp[prev] == INF) continue; // 이전 금액이 0원보다 적은 금액이거나, coins[j]원을 더하기 전인 이전 금액이 주어진 동전들로 만들 수 없었던 경우,
                dp[i] = Math.min(dp[i], dp[prev] + 1); 
            }
        }
        if(dp[M] == INF){ // 돈을 거슬러 주는 것이 불가능할 경우, 
            dp[M] = -1;
        }
        System.out.println(dp[M]);


    }
}