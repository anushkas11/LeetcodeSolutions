class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node copy = new Node(node.val);
        Map<Node, Node> map= new HashMap<>();
        map.put(node, copy);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node curr= q.poll();
            for(Node n : curr.neighbors){
                if(!map.containsKey(n)){
                    Node clone= new Node(n.val);
                    q.add(n);
                    map.put(n, clone);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return copy; 
    }
}