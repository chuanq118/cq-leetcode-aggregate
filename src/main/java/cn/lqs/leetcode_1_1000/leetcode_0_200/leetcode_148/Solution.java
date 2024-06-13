package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_148;

class Solution {
    public ListNode sortList(ListNode head) {
      ListNode fakeHead = new ListNode(0, head);
      sort(fakeHead, head, null);
      return fakeHead.next;
    }

    private void sort(ListNode sprev, ListNode start, ListNode end){
      if(start == null || start == end){
        return;
      }
      ListNode cur = start.next;
      ListNode prev = start;
      while(cur != end){
        if(cur.val < start.val){
          prev.next = cur.next;
          cur.next = sprev.next;
          sprev.next = cur;
          cur = prev.next;
          continue;
        }
        prev = cur;
        cur = cur.next;
      }
      sort(sprev, sprev.next, start);
      sort(start, start.next, null);
    }

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String[] args) {
    ListNode node4 = new ListNode(4);
    ListNode node2 = new ListNode(2);
    ListNode node1 = new ListNode(1);
    ListNode node3 = new ListNode(3);

    node4.next = node2;
    node2.next = node1;
    node1.next = node3;

    new Solution().sortList(node4);
  }
}