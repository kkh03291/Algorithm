/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node cur = head;
        childRemove(cur);
        return head;
    }

    public Node childRemove(Node node) {
        if (node == null) return null;
        while(node != null) {
            if (node.child != null) {
                Node next = node.next;
                Node child = node.child;
                node.child = null;
                node.next = child;
                child.prev = node;
                node = childRemove(child);
                if (next != null) next.prev = node;
                node.next = next;
            }
            if (node.next == null) break;
            node = node.next;
        }
        return node;
    }
}