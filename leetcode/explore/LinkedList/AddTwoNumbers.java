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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int index = 0, carry = 0, l1Value = 0, l2Value = 0;
        ListNode result = new ListNode(0);
        ListNode head = result;// head
        while(l1 != null || l2 != null) {
            l1Value = (l1 == null) ? 0 : l1.val;
            l2Value = (l2 == null) ? 0 : l2.val;

            int sum = l1Value + l2Value;
            sum += carry;
            carry = 0;
            if (sum >= 10) {
                carry = 1;
                sum = sum % 10;
            }
            ListNode node = new ListNode(sum);
            result.next = node;
            result = node;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        if (carry > 0) result.next = new ListNode(carry);
        return head.next;
    }
}