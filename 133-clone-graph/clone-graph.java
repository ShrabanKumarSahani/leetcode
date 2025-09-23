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
// DFS
class Solution {
    Map<Node, Node> map = new HashMap<>();  // for original to clone

    public Node cloneGraph(Node node) {
        if(node == null) return null;

        // already cloned
        if(map.containsKey(node)) {
            return map.get(node);   
        }

        // create new node
        Node clone = new Node(node.val);    
        map.put(node, clone);

        // recursion to clone neighbours
        for(Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
/**
TC = O(nNodes + nEdges)
SC = O(nNodes) */