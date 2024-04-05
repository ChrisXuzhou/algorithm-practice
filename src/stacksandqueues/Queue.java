package stacksandqueues;

import java.util.NoSuchElementException;
import java.util.Stack;

public class Queue {

    private final Stack<Integer> pushStack = new Stack<>();
    private final Stack<Integer> fetchStack = new Stack<>();

    public void push(int val) {
        pushStack.push(val);
    }

    public Integer pop() {

        if (fetchStack.isEmpty()) {
            fullFillFetchStack();
        }
        if (fetchStack.isEmpty()) {
            throw new NoSuchElementException();
        }
        return fetchStack.pop();
    }

    private void fullFillFetchStack() {
        while (!pushStack.isEmpty()) {
            fetchStack.push(pushStack.pop());
        }
    }
}
