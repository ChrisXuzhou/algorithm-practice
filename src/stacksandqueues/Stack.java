package stacksandqueues;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class Node {
    int val;
    int min;

    public Node(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

public class Stack {

    private final List<Node> array = new ArrayList<>();
    // Implement a stack using arrays or linked lists with push, pop, and min operations in O(1) time complexity.

    public void push(int v){
        // push to the end.
        // todo Here should check the first insert scenario
        if (array.isEmpty()) {
            array.add(new Node(v, v));
        } else {
            Node last = array.getLast();
            Node created = new Node(v, Math.min(last.min, v));
            array.add(created);
        }
    }

    public int pop() {
        // pop from end
        if (array.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Node l = array.getLast();
            array.removeLast();
            return l.val;
        }
    }

    public int min() {
        if (array.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Node l = array.getLast();
            return l.min;
        }
    }

}
