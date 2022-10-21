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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;
        int length = 0;
        while (end != null) {
            end = end.next;
            length++;
        }
        if (length == n) {
            head = head.next;
            return head;
        }
        length -= n;
        end = head;
        for (int i = 1; i < length; i++) {
            end = end.next;
        }
        if (end.next == null) return null;
        end.next = end.next.next;
        return head;

    }
}