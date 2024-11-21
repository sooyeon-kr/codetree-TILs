import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static List<Point> arr;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new ArrayList<>();
        
        long maxNum = 0;
        for(int i=0; i<m; ++i){
            arr.add(new Point(sc.nextLong(), sc.nextLong()));
            maxNum = Math.max(maxNum, arr.get(i).b);
        }

        Collections.sort(arr);

        long st = 1, en = maxNum;
        long maxDist = 0;
        while(st <= en){
            long mid = (st + en) / 2;

            if(isPossible(mid)){
                st = mid + 1;
                maxDist = Math.max(maxDist, mid);
            }
            else{
                en = mid - 1;
            }
        }

        System.out.println(maxDist);
    }

    static boolean isPossible(long target){
        int cnt = 1;

        long st = arr.get(0).a;
        for(int i=0; i<m; ++i){
            while(true){
                if(arr.get(i).b - st >= target){
                    if(arr.get(i).a <= st + target){
                        st += target;
                    }
                    else st = arr.get(i).a;
                    cnt++;
                    if(cnt >= n) return true;
                }
                else{
                    break;
                }
            }
        }

        return false;
    }

    static class Point implements Comparable<Point>{
        long a,b;

        Point(long a, long b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Point o){
            if(a == b){
                if(this.b > o.b) return 1;
                return -1;
            }
            if(this.a > o.a) return 1;
            return -1;
        }
    }
}