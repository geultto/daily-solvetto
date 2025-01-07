import java.util.*;

class Solution {
    static class Node {
        private int index;
        private int x;
        private int y;
        private Node left;
        private Node right;
        
        public Node(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }
    
    Node Root;
    private static List<Integer> preOrderNodes = new ArrayList<>();
    private static List<Integer> postOrderNodes = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();
        
        for (int i = 0; i < nodeinfo.length; ++i) {
            nodes.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        
        Collections.sort(nodes, new Comparator<Node>(){
            public int compare(Node a, Node b) {
                if (a.y == b.y) {
                    return a.x - b.x;
                }
                return b.y - a.y;
            }
        });
        
        Root = nodes.get(0);
        for (int i = 1; i < nodes.size(); ++i) {
            insert(Root, nodes.get(i));
        }
        
        preOrder(Root);
        postOrder(Root);
        
        return new int[][]{
            preOrderNodes.stream().mapToInt(Integer::intValue).toArray(),
            postOrderNodes.stream().mapToInt(Integer::intValue).toArray(),
        };
    }
    
    private void insert(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }
    
    private void preOrder(Node current) {
        if (current == null) {
            return;
        }
        preOrderNodes.add(current.index);
        preOrder(current.left);
        preOrder(current.right);
    }
    
    private void postOrder(Node current) {
        if (current == null) {
            return;
        }
        postOrder(current.left);
        postOrder(current.right);
        postOrderNodes.add(current.index);
    }
}