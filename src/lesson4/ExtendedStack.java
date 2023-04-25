package lesson4;

import java.util.EmptyStackException;

public class ExtendedStack extends Stack {

    private Stack minMemory;  // используем для хранения минимальных значений

    public static void main(String[] args) {
        ExtendedStack stack = new ExtendedStack();
        stack.push(10);
        stack.push(-100);
        stack.push(2);
        stack.push(-200);
        assert stack.top() == -200;
        assert stack.size() == 4;
        assert stack.min() == -200;
        stack.pop();
        assert stack.size() == 3;
        assert stack.top() == 2;
        assert stack.min() == - 100;
    }

    public ExtendedStack() {
        super();
        minMemory = new Stack();
    }

    public void push(int data) {
        if (data <= min()) {
            minMemory.push(data);
        }
        // здесь удобно использовать метод родительского класса
        super.push(data);
    }

    public int pop() throws EmptyStackException {
        // метод родительского класса super.pop() неудобно использовать, используем геттеры и сеттеры
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        if (top() == min()) {
            minMemory.pop();
        }
        Node oldHead = getHead();
        setHead(getHead().getPrev());
        setSize(getSize() - 1);
        return oldHead.getData();
    }

    public int min() {
        if (minMemory.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return minMemory.top();
    }

}

class Stack {

    private Node head;  // верхний элемент стэка (top)

    private int size = 0;  // изначально размер стэка равен 0

    public Stack() {
        //head = null;
    }

    public void push(int data) {
        if (isEmpty()) {
            head = new Node(data, null);
            size++;
            return;
        }
        head = new Node(data, head);
        size++;
    }

    public int pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node oldHead = head;
        head = head.getPrev();
        size--;
        return oldHead.getData();
    }

    public int size() {
        return size;
    }

    public int top() {
        return head.getData();
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

}

class Node {

    private int data;

    private Node prev;

    public Node(int data, Node prev) {
        this.data = data;
        this.prev = prev;
    }

    public int getData() {
        return data;
    }

    public Node getPrev() {
        return prev;
    }

}