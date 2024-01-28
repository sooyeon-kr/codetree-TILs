import java.io.*;
import java.util.*;

public class Main {
    static final int MN = 105;
    static final int MT = 105;
    static int N, M;
    static int[] dp = new int[MT];
    static int[] times = new int[MN];
    static int[] exps = new int[MN];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int sumT = 0;
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            exps[i] = Integer.parseInt(st.nextToken());
            times[i] = Integer.parseInt(st.nextToken());
            sumT += times[i];
        }

        Arrays.fill(dp, 0, sumT+1, -1);
        dp[0] = 0;
        for(int i=0; i<N; ++i){
            for(int j=sumT; j>0; --j){
                if(j<times[i] || dp[j-times[i]]==-1) continue;
                dp[j] = Math.max(dp[j], dp[j-times[i]]+exps[i]);
            }
        }

        int ans = -1;
        for(int i=0; i<=sumT; ++i){
            if(dp[i] >= M){
                ans = i;
                break;
            }
        }

        System.out.println(ans);


	
    }
}