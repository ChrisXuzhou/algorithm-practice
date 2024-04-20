package mostlikelyasked;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));

    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    private Map<Integer, Node> cache = new HashMap<>();
    private int capacity;
    private Node head = new Node();
    private Node tail = new Node();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            node = new Node();
            node.key = key;
            node.value = value;

            cache.put(key, node);

            // add new node into the top of the list
            addNode(node);

            if (cache.size() > capacity) {
                // remove from the tail
                Node pop = popTail();
                cache.remove(pop.key);
            }

        } else {
            node.value = value;

            // move the origin node to the top of the list
            moveToHead(node);
        }
    }

    private Node popTail() {
        Node node = tail.prev;
        Node prev = node.prev;
        prev.next = tail;
        tail.prev = prev;

        return node;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void addNode(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;

        node.next = next;
        next.prev = node;
    }
}