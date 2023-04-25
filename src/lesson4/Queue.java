package lesson4;

import java.util.EmptyStackException;

public class Queue {
    private Stack in = new Stack();

    private Stack out = new Stack();

    private int size = 0;

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(10);
        queue.push(-100);
        queue.push(2);
        queue.push(-200);
        assert queue.front() == 10;
        assert queue.size() == 4;
        assert queue.pop() == 10;
        assert queue.pop() == -100;
    }

    public void push(int data) {
        in.push(data);
        size++;
    }

    public int pop() throws EmptyStackException {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        size--;
        return out.pop();
    }

    public int front() throws EmptyStackException {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.top();
    }

    public int size() {
        return size;
    }

}
