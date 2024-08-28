package bishi.dewu_0828.q3;

import java.util.Scanner;
import java.util.Stack;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String line = in.nextLine();
        Stack<Character> stk = new Stack<>();
        int i = 0;
        for (; i < n; i++) {
            char ch = line.charAt(i);
            if (stk.isEmpty() || ch == '(') {
                if (ch == ')') {
                    break;
                }
                stk.push(ch);
            } else if (stk.pop() != '(') {
               break;
            }
        }
        if (stk.isEmpty()) {
            System.out.println(i);
        } else {
            System.out.println(0);
        }
    }
}
