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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        // ListNode tmp;
        while (odd != null && odd.next != null && even != null && even.next != null) {
            // tmp = odd.next;
            odd.next = odd.next.next;
            odd = odd.next;

            // tmp = even.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}