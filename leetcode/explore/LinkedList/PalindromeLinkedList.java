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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) slow = slow.next;

        ListNode tail = reverse(slow);

        while(tail != null) {
            if (head.val != tail.val) return false;
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    public ListNode reverse(ListNode node) {
        ListNode tail = null;

        while (node != null) {
            ListNode next = node.next;
            node.next = tail;
            tail = node;
            node = next;
        }
        return tail;
    }
}