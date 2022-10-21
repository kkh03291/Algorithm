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
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null && cur.next != null) {
            tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }
}