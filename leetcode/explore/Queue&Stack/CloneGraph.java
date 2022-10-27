/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashSet<Node> visit = new HashSet<>();
        Map<Node, Node> map = new HashMap<>();
        return copy(node, visit, map);

    }

    public Node copy(Node node, HashSet<Node> visit, Map<Node, Node> map) {
        visit.add(node);
        Node copy = new Node(node.val);
        map.put(node, copy);
        for (Node n : node.neighbors) {
            if (visit.contains(n)) {
                copy.neighbors.add(map.get(n));
                continue;
            }
            copy.neighbors.add(copy(n, visit, map));
        }
        return copy;
    }
}