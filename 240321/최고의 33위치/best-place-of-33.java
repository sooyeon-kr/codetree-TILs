import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];

        for(int y=0; y<n; ++y){
            String[] str = br.readLine().split(" ");
            for(int x=0; x<n; ++x){
                grid[y][x] = Integer.parseInt(str[x]);
            }
        }

        int ans = 0;
        for(int y=0; y<n; ++y){
            for(int x=0; x<n; ++x){
                ans = Math.max(ans, getCoinCnt(y, x, n, grid));
            }
        }

        bw.write(Integer.toString(ans));
        bw.close();
        br.close();
    }

    static int getCoinCnt(int y, int x, int n, int[][] grid){
        int eY=y+3, eX=x+3;
        if(n-y<3){
            eY = n;
        }
        if(n-x<3){
            eX = n;
        }
        int cnt = 0;
        for(int r=y; r<eY; ++r){
            for(int c=x; c<eX; ++c){
                cnt += grid[r][c];
            }
        }
        return cnt;
    }
}