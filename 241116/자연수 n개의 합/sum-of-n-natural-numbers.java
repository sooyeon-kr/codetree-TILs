import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        System.out.println(parametic(s));
    }

    static long parametic(long s){
        long left = 1, right = (long)Math.sqrt(s) + 10;
        long minNum = 0;

        while(left <= right){
            long mid = (left + right) / 2;
        
            if(mid * (mid + 1) > s * 2){
                right = mid -1;
            }

            else{
                left = mid + 1;
                minNum = Math.max(minNum, mid);
            }
        }
        return minNum;    
    }

    static boolean func(long n, long s){
        return (n+1) * n / 2 <= s;
    }
}