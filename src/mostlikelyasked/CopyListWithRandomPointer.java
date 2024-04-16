package mostlikelyasked;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {

        Map<Node, Node> origin2newed = new HashMap<>();
        Node n = head;
        while (n != null) {
            Node newed = new Node(n.val);
            origin2newed.put(n, newed);
            n = n.next;
        }

        n = head;
        while (n!= null) {
            Node newed = origin2newed.get(n);
            newed.next = n.next == null ? null : origin2newed.get(n.next);
            newed.random = n.random == null ? null : origin2newed.get(n.random);
            n = n.next;
        }

        return origin2newed.get(head);
    }

}
