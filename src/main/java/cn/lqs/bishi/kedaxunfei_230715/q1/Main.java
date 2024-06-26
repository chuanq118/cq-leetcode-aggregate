import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = 0;
        for(int i = 0; i < n; i += 1){
            int num = in.nextInt();
            String sNum = String.valueOf(num);
            int cnt = 0;
            for(char ch : sNum.toCharArray()){
                if(ch == '0'){
                    continue;
                }
                cnt += 1;
            }
            ans += cnt;
        }
        System.out.println(ans);
    }
}

