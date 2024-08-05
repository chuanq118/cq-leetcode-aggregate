import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        char[] s = in.nextLine().toCharArray();
        int l = 0;
        StringBuilder ans = new StringBuilder();
        while(l < s.length){
            int r = l;
            while(r < s.length && s[l] == s[r]){
                r += 1;
            }
            int len = r - l;
            if(len < 3 || len == 4){
                System.out.println(-1);
                return;
            }
            while(len > 3 && len % 2 == 0){
                len -= 3;
                for(int i = 0; i < 3; i += 1){
                    ans.append(s[l]);
                }
                ans.append(' ');
            }
            for(int i = 0; i < len; i += 1){
                ans.append(s[l]);
            }
            ans.append(' ');
            l = r;
        }
        System.out.println(ans.deleteCharAt(ans.length() - 1).toString());
    }
}