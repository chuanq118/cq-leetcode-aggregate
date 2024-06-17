package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_147;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode fkHead = new ListNode(0, head);
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val < prev.val){
                prev.next = cur.next;
                ListNode findCur = fkHead;
                while(findCur.next.val < cur.val){
                    findCur = findCur.next;
                }
                cur.next = findCur.next;
                findCur.next = cur;
                cur = prev.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        return fkHead.next;
    }
}