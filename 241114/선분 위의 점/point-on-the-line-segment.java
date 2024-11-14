import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0; i<M; ++i){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            System.out.println(upper(arr, e) - lower(arr, s));
        }
    }

    static int lower(int[] arr, int target){
        int st = 0, en = arr.length -1;
        int maxIdx = en + 1;

        while(st <= en){
            int mid = (st+en) / 2;

            if(arr[mid] >= target){
                en = mid - 1;
                maxIdx = Math.min(maxIdx, mid);
            }

            else{
                st = mid + 1;
            }
        }

        return maxIdx;
    }

    static int upper(int[] arr, int target){
        int st = 0, en = arr.length -1;
        int maxIdx = en + 1;

        while(st <= en){
            int mid = (st+en) / 2;

            if(arr[mid] > target){
                en = mid - 1;
                maxIdx = Math.min(maxIdx, mid);
            }

            else{
                st = mid + 1;
            }
        }

        return maxIdx;
    }
}