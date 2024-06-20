
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] dist = new int[n];
        long total = 0;
        for(int i = 0; i < n; i += 1){
            dist[i] = in.nextInt();
            total += dist[i];
        }
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        long way1Dist = 0;
        for(int k = Math.min(x, y); k < Math.max(x, y); k += 1){
            way1Dist += dist[k];
        }
        System.out.println(Math.min(way1Dist, total - way1Dist));
    }
}