package mostlikelyasked;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<String, TrieNode> children;
    int val;

    public TrieNode() {
        this.val = -1;
        this.children = new HashMap<>();
    }
}

public class DesignFileSystem {

    TrieNode root = new TrieNode();

    public boolean createPath(String path, int value) {
        // Returns false if the path already exists or its parent path doesn't exist.
        String[] directives = path.split("/");

        TrieNode curr = root;
        for (String dir : directives) {
            if (!curr.children.containsKey(dir)) {
                curr.children.put(dir, new TrieNode());
            }
            curr = curr.children.get(dir);
        }

        if (curr.val == -1) {
            curr.val = value;
            return true;
        }

        return false;
    }

    public int get(String path) {

        String[] directives = path.split("/");

        TrieNode curr = root;
        for (String dir : directives) {
            if (!curr.children.containsKey(dir)) {
                return -1;
            }
            curr = curr.children.get(dir);
        }

        return curr.val;
    }

}
