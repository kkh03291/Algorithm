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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }

        k = k % length;
        length -= k;
        int idx = 1;
        ListNode start = head;
        while (idx < length) {
            idx++;
            start = start.next;
        }
        // System.out.print(start.val);
        tail.next = head;
        head = start.next;
        start.next = null;
        // tail.next = start;
        // start.next = null;
        return head;
    }
}