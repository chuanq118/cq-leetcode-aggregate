package cn.lqs.bishi.huawei_230823.q2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line;
        StringBuilder sb = new StringBuilder();
        sb.append('|');
        int curIdx = 0;
        while (true) {
//            System.out.println(sb.toString());
            line = in.nextLine().trim();
            if (line.startsWith("insert")) {
                String str = line.substring("insert".length() + 1);
                sb.insert(curIdx, str);
                curIdx = curIdx + str.length();
            } else if (line.startsWith("delete")) {
                int delCnt = Integer.parseInt(line.substring("delete".length() + 1));
                int copyCnt = delCnt;
                if (delCnt > 0 && delCnt <= curIdx) {
                    int delIdx = curIdx - 1;
                    while (delCnt > 0) {
                        sb.deleteCharAt(delIdx);
                        delIdx -= 1;
                        delCnt -= 1;
                    }
                    curIdx -= copyCnt;
                }
            } else if (line.startsWith("move")) {
                int moveCnt = Integer.parseInt(line.substring("move".length() + 1));
                int rightChars = sb.length() - curIdx - 1;
                int leftChars = curIdx;
                if (moveCnt > 0 && moveCnt <= rightChars) {
                    sb.deleteCharAt(curIdx);
                    curIdx = curIdx + moveCnt;
                    sb.insert(curIdx, '|');
                } else if (moveCnt < 0 && Math.abs(moveCnt) <= leftChars) {
                    sb.deleteCharAt(curIdx);
                    curIdx = curIdx - Math.abs(moveCnt);
                    sb.insert(curIdx, '|');
                }
            } else if (line.startsWith("copy")) {
                String copyStr = sb.substring(0, curIdx);
                sb.insert(curIdx + 1, copyStr);
            } else if (line.startsWith("end")) {
                break;
            }
        }
        System.out.println(sb.toString());
    }
}
