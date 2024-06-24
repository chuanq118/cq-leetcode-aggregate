import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] arr = new int[m][2];
        for(int i = 0; i < m; i += 1){
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        // Arrays.sort(arr, (prev, next) -> {
        //     if(prev[0] == next[0]){
        //         return prev[1] - next[1];
        //     }
        //     return prev[0] - next[0];
        // });
        int ans = 0;
        // Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i < arr.length; i += 1){
            int curLen = arr[i][1] - arr[i][0];
            if(curLen >= k){
                ans = k;
                break;
            }
            int ei = arr[i][0] + k;
            for(int j = i + 1; j < arr.length && arr[j][0] < ei; j += 1){
                curLen += (Math.min(arr[j][1], ei) - arr[j][0]);
            }
            ans = Math.max(ans, curLen);
        }
        System.out.println(ans);
    }
}