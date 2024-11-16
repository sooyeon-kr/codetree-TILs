import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }

        System.out.println(parametic(arr, M));
    }

    static int parametic(int[] arr, int m){
        int left = 1, right = 10000;
        int maxNum = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            
            if(isPossible(arr, mid, m)){
                left = mid + 1;
                maxNum = Math.max(maxNum, mid);
            }
            else{
                right = mid -1;
            }
        }

        return maxNum;
    }

    static boolean isPossible(int[] arr, int target, int m){
        int cnt = 0;

        for(int num : arr){
            cnt += num / target;
        }

        if(cnt >= m) return true;
        return false;
    }
}