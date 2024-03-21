import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] grid = new int[N][N];
        
        for(int y=0; y<N; ++y){
            input = br.readLine().split(" ");
            for(int x=0; x<N; ++x){
                grid[y][x] = Integer.parseInt(input[x]);
            }
        }

        int cnt = 0;
    
        for(int x=0; x<N; ++x){
            if(isHappySeqCol(0, x, grid, N, M)) ++cnt;
            if(isHappySeqRow(x, 0, grid, N, M)) ++cnt;
        }
    

        bw.write(Integer.toString(cnt));
        bw.close();

    }

    static boolean isHappySeqRow(int r, int c, int[][] grid, int n, int m){
        int prev = grid[r][c];
        int cnt = 0;
        for(int x=0; x<n; ++x){
            if(grid[r][x]==prev){
                ++cnt;
            }else{
                prev = grid[r][x];
                cnt = 1;
            }
            if(cnt >= m) return true;
        }
        return false;
    }


    static boolean isHappySeqCol(int r, int c, int[][] grid, int n, int m){
        int prev = grid[r][c];
        int cnt = 0;
        for(int y=0; y<n; ++y){
            if(grid[y][c]==prev){
                ++cnt;
            }else{
                prev = grid[y][c];
                cnt = 1;
            }
            if(cnt >= m) return true;
        }
        return false;
    }  
}