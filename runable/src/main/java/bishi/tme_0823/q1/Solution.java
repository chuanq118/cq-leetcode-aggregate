package bishi.tme_0823.q1;

import java.util.*;

  class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param a ListNode类 
     * @return int整型
     */
    public int merge (ListNode a) {
        // write code here
        ListNode cur = a;
        boolean needZero = cur.val != 0;
        int ans = 0;
        while (cur != null && cur.next != null) {
            ListNode prev = cur;
            cur = cur.next;
            if (needZero && cur.val == 0) {
                needZero = false;
                continue;
            }
            if (!needZero && cur.val != 0) {
                needZero = true;
                continue;
            }
            if (needZero) {
                while (cur != null && cur.val != 0) {
                    cur = cur.next;
                    ans += 1;
                }
                if (cur != null) {
                    prev.next = cur;
                }
            }
            if (!needZero) {
                while (cur.val == 0 && cur.next != null) {
                    cur.val = Math.max(cur.val, cur.next.val);
                    cur.next = cur.next.next;
                    ans += 1;
                }
                if (cur.val == 0) {
                    ans += 1;
                }
            }
            needZero = !needZero;
        }
        return ans;
    }
}