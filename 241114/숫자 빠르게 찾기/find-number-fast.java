import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; ++i){
            int tmp = Integer.parseInt(br.readLine());
            func(arr, tmp);
        }
    }

    public static void func(int[] arr, int target){

        int st = 0, en = arr.length-1;

        while(st <= en){
            int mid = (st + en) / 2;
            if(arr[mid] == target){
                System.out.println(mid+1);
                return;
            }

            if(arr[mid] > target){
                en = mid - 1;
            }
            else{
                st = mid + 1;
            }
        }

        System.out.println(-1);
    }
}