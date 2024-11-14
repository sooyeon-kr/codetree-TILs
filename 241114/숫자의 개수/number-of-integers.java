import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int arr[] = new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<M; ++i){
            int tmp = sc.nextInt();
            
            System.out.println(func(arr, tmp));
        }
    }

    public static int func(int[] arr, int target){
        return upper(arr, target) - lower(arr, target);
    }

    public static int lower(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        int maxIdx = right+1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] >= target){
                right = mid - 1;
                maxIdx = Math.min(maxIdx, mid);
            }
            
            else{
                left = mid + 1;
            }
        }

        return maxIdx;
    }

    public static int upper(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        int maxIdx = right+1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] > target){
                right = mid - 1;
                maxIdx = Math.min(maxIdx, mid);
            }
            
            else{
                left = mid + 1;
            }
        }

        return maxIdx;
    }
}