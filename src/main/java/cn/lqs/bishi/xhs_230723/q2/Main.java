import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] arr = new int[m][2];
        Arrays.sort(arr, (prev, next) -> {
            if(prev[0] == next[0]){
                return prev[1] - next[1];
            }
            return prev[0] - next[0];
        });
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i < k; i += 1){
            arr[i]
        }
    }
}