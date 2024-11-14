import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());        
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; ++i){
            System.out.println(func(arr, Integer.parseInt(st.nextToken())));
        }
    }

    static int func(int[] arr, int target){
        int low = lower(arr, target);
        int upp = upper(arr, target);

        return low == upp ? -1 : low+1;
    }

    static int lower(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        int maxIdx = right + 1;

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

    static int upper(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        int maxIdx = right + 1;

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