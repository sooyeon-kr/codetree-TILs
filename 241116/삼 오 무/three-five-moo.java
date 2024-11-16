import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(parametic(N));
    }

    static long parametic(int N){
        long left = 1, right = Integer.MAX_VALUE;
        long minNum = Integer.MAX_VALUE;
        while(left <= right){
            long mid = (left + right+1) / 2;
            long cnt = func(mid);
            if(cnt == N){
                while(true){
                    if(mid % 3 !=0 && mid % 5 != 0){
                        return mid;
                    }
                    mid--;
                }
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

    static long func(long num){
        return num - num / 3 - num / 5 + num / 15;
    }
}