class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }
      ListNode fa = head, sl = head;
      while (fa.next != null && fa.next.next != null) {
        sl = sl.next;
        fa = fa.next.next;
      }
      ListNode head2 = sl.next;
      sl.next = null;
      ListNode sortedHead1 = mergeSort(head);
      ListNode sortedHead2 = mergeSort(head2);
      ListNode fkHead = new ListNode();
      ListNode cur = fkHead;
      ListNode cur1 = sortedHead1;
      ListNode cur2 = sortedHead2;
      while(cur1 != null && cur2 != null) {
        if (cur1.val < cur2.val) {
          cur.next = cur1;
          cur1 = cur1.next;
        } else {
          cur.next = cur2;
          cur2 = cur2.next;
        }
        cur = cur.next;
      }
      cur.next = cur1 == null ? cur2 : cur1;
      return fkHead.next;
    }

}