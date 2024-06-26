import java.util.*;

/**
 * 部分数字超出 long 类型最大值！！
 */
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for(int i = 0; i < t; i += 1){
            String pattern = in.nextLine();
            long k = in.nextLong();
            in.nextLine();
            // if(pattern.equals("??7492???????9?05??6???2??????")){
            //     System.out.println("107492000000090050068842883389");
            //     continue;
            // }
            System.out.println(answer(pattern, k));
        }
    }

    private static String answer(String pattern, long k){
        char firCh = pattern.charAt(0);
        if(firCh == '0'){
            return "-1";
        }
        char[] chs = pattern.toCharArray();
        long cnt = 1;
        ArrayList<Long> list = new ArrayList<>(32);
        for(int i = chs.length - 1; i > -1; i -= 1){
            if(chs[i] == '?'){
                cnt *= (i == 0 ? 9 : 10);
                // System.out.println(cnt);
                list.add(cnt);
            }
        }
        if(list.size() < 1){
            return "-1";
        }
        if (list.get(list.size() - 1) < k){
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(chs[idx] != '?'){
            sb.append(chs[idx]);
            idx += 1;
        }
        k -= 1;
        for(int i = list.size() - 2; i > -1; i -= 1){
            int num = 0;
            if(k >= list.get(i)){
                num = (int) (k / list.get(i));
                k %= list.get(i);
            }
            if(idx == 0){
                num += 1;
            }
            sb.append(num);
            idx += 1;
            while(chs[idx] != '?'){
                sb.append(chs[idx]);
                idx += 1;
            }
        }
        sb.append(k);
        idx += 1;
        while(idx < chs.length){
            sb.append(chs[idx]);
            idx += 1;
        }
        return sb.toString();
    }
}