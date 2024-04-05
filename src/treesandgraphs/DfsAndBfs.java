package treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    int val;

    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}

public class DfsAndBfs {

    // Implement depth-first search (DFS) and breadth-first search (BFS) for a binary tree or graph.

    public Node searchDFS(Node node, int val) {

        Stack<Node> cache = new Stack<>();
        cache.push(node);

        Node curr = cache.pop();
        while (curr != null) {
            if (curr.val == val) {
                return curr;
            }
            if (curr.right != null) {
                cache.push(curr.right);
            }
            if (curr.left != null) {
                cache.push(curr.left);
            }

            curr = cache.isEmpty() ? null :cache.pop();
        }
        return null;
    }

    public Node searchBFS(Node node, int val) {

        Queue<Node> cache = new LinkedList<>();
        cache.add(node);

        Node curr = cache.remove();
        while (curr != null) {
            if (curr.val == val) {
                return curr;
            }
            if (curr.left != null) {
                cache.add(curr.left);
            }
            if (curr.right != null) {
                cache.add(curr.right);
            }

            curr = cache.isEmpty() ? null :cache.remove();
        }
        return null;
    }


}
