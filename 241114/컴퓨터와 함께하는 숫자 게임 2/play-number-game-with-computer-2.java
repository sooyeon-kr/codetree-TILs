import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();

        // System.out.println(m + " " + a + " " + b);

        int minCnt = 100001;
        int maxCnt = 0;
        for(long i = a; i<=b; ++i){
            int ret = func(m,i);
            minCnt = Math.min(minCnt, ret);
            maxCnt = Math.max(maxCnt, ret);
        }

        System.out.println(minCnt + " " + maxCnt);
    }

    static int func(long m, long target){
        long left = 1, right = m;
        int cnt = 0;

        while(left <= right){
            long mid = (left + right) / 2;
            cnt++;

            if(mid == target){
                return cnt;
            }

            if(mid > target){
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
        }

        return -1;
    }
}