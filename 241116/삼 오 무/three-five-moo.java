import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(parametic(N));
    }

    static int parametic(int N){
        int left = 1, right = 2_000_000_000;
        int minNum = 2_000_000_001;
        while(left <= right){
            int mid = (left + right) / 2;
            int cnt = func(mid);
            if(cnt == N){
                right = mid - 1;
                minNum = Math.min(minNum, mid);
            }

            else if(cnt > N){
                right = mid -1;
            }

            else{
                left = mid + 1;
            }
        }

        return minNum;
    }

    static int func(int num){
        return num - num / 3 - num / 5 + num / 15;
    }
}