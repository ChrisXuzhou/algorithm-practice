package mostlikelyasked;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    static class Node {
        char c;
        boolean isEnd = false;
        Map<Character, Node> children = new HashMap<>();

        public Node(char c) {
            this.c = c;
        }
    }

    private final Node root;

    public Trie() {
        root = new Node('0');
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node n = root;
        for (char c: chars) {
            if (!n.children.containsKey(c)) {
                n.children.put(c, new Node(c));
            }
            n = n.children.get(c);
        }
        n.isEnd = true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node n = root;
        for (char c: chars) {
            if (!n.children.containsKey(c)) {
                return false;
            }
            n = n.children.get(c);
        }
        return n.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node n = root;
        for (char c: chars) {
            if (!n.children.containsKey(c)) {
                return false;
            }
            n = n.children.get(c);
        }
        return true;
    }

}
