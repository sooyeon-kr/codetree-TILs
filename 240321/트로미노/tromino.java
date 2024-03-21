import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] grid = new int[n][m];

        for(int y=0; y<n; ++y){
            input = br.readLine().split(" ");
            for(int x=0; x<m; ++x){
                grid[y][x] = Integer.parseInt(input[x]);
            }
        }

        int ans = 0;

        for(int y=0; y<n; ++y){
            for(int x=0; x<m; ++x){
                ans = Math.max(ans, getMaxSum(grid, y, x, n, m));
            }
        }

        bw.write(Integer.toString(ans));
        bw.close();
    }

    static int getMaxSum(int[][] grid, int r, int c, int n, int m){
        int ret = 0;
        if(n-r>=2 && m-c>=2){
            int sum = grid[r][c] + grid[r][c+1] + grid[r+1][c] + grid[r+1][c+1];
            ret = Math.max(ret, sum-grid[r][c]);
            ret = Math.max(ret, sum-grid[r][c+1]);
            ret = Math.max(ret, sum-grid[r+1][c]);
            ret = Math.max(ret, sum-grid[r+1][c+1]);
        }

        if(m-c>=3){
            int sum = grid[r][c] + grid[r][c+1] + grid[r][c+2];
            ret = Math.max(ret, sum);
        }

        if(n-r>=3){
            int sum = grid[r][c] + grid[r+1][c] + grid[r+2][c];
            ret = Math.max(ret, sum);
        }

        return ret;
    }
}