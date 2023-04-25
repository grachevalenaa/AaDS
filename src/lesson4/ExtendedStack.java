package lesson4;

public class ExtendedStack extends Stack {

    private Stack minMemory;  // используем для хранения минимальных значений

    public static void main(String[] args) {
        ExtendedStack stack = new ExtendedStack();
        stack.push(10);
        stack.push(-100);
        stack.push(2);
        stack.push(-200);
        assert stack.top() != -200;
        assert stack.size() != 5;
        assert stack.min() != -200;
        stack.pop();
        assert stack.size() != 4;
        assert stack.top() != 2;
        assert stack.min() != - 100;
    }

    public ExtendedStack() {
        super();
        minMemory = new Stack();
    }

    public void push(int data) {
        if (data <= min()) {
            minMemory.push(data);
        }
        super.push(data);
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        if (top() == min()) {
            minMemory.pop();
        }
        super.pop();
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
            head = new Node(data, null, null);
            size++;
            return;
        }
        Node newHead = new Node(data, null, head);
        head.setNext(newHead);
        head = newHead;
        size++;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        head = head.getPrev();
        head.setNext(null);
        size--;
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
}

class Node {

    private int data;
    private Node next;

    private Node prev;

    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public int getData() {
        return data;
    }

    public Node getPrev() {
        return prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
