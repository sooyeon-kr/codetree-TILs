import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr= new int[n];

        for(int i=0; i<n; ++i){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        para(arr, m);
    }

    static void para(int[] arr, int m){

        int lo = 0, hi = 1_000_000_000;
        int maxNum = 0;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(isPossible(mid, arr, m)){
                lo = mid + 1;
                // System.out.println(mid + " &&&");
                maxNum = Math.max(mid, maxNum);
            }
            else{
                hi = mid - 1;
            }
        }

        System.out.println(maxNum);
    }

    static boolean isPossible(int target, int[] arr, int targetCnt){
        int st = 0, en = 1;
        int cnt = 0;
        while(en < arr.length){
            if(arr[en] - arr[st] >= target){
                cnt++;
                st = en;
            }
            en++;
        }

        if(arr[en-1] - arr[st] >= target) cnt++;

        // System.out.println(target + " " + cnt);

        if(cnt + 1 >= targetCnt){
            return true;
        }

        return false;
    }
}