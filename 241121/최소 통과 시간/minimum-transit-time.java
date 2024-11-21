import java.util.*;

public class Main {

    static long[] arr;
    static int n,m;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new long[m];

        long maxNum = 1;
        for(int i=0; i<m; ++i){
            arr[i] = sc.nextLong();
            maxNum = Math.max(maxNum, arr[i]);
        }

        maxNum *= m;

        long st = 1, en = maxNum;
        long maxTime = maxNum;

        while(st <= en){
            long mid = (st + en) / 2;
            if(func(mid)){
                en = mid - 1;
                maxTime = Math.min(maxTime, mid);
            }
            else{
                st = mid + 1;
            }
        }

        System.out.println(maxTime);
    }

    static boolean func(long target){

        int sum = 0;
        for(int i=0; i<m; ++i){
            sum += target / arr[i];
            if(sum >= n) return true;
        }

        return false;
    }
}