import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] coins = new int[n];
        for(int i=0; i<n; ++i){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int i = n-1;
        while(k!=0){
            cnt += k / coins[i];
            k %= coins[i]; 
            i--;
        }
        System.out.println(cnt);

    }
}