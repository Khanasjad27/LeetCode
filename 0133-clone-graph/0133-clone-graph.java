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
    private Node cloneGraph(Node node, HashMap<Node, Node> mp) {
        Node newNode = new Node(node.val);
        mp.put(node, newNode);

        for (Node neighbor : node.neighbors) {
            // If the neighbor hasn't been cloned yet, call the recursive function and add the returned clone directly
            if (!mp.containsKey(neighbor)) {
                newNode.neighbors.add(cloneGraph(neighbor, mp));
            } else {
                // Otherwise, fetch the existing clone from the map
                newNode.neighbors.add(mp.get(neighbor));
            }
        }
        return newNode;
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        HashMap<Node, Node> mp = new HashMap<>();
        return cloneGraph(node, mp);
    }
}