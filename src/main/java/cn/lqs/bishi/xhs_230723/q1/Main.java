import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if(n <= 2){
            System.out.println(k);
            return;
        }
        long sum = (long)(1 + n) * (n) / 2;
        System.out.println(sum * k);
    }

    private static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}