package datastructure;

public class LinkedListQueue {
    public Node head;
    public Node tail;

    public LinkedListQueue() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public Object front() throws Exception {
        if (isEmpty())
            throw new Exception();
        return (head.info);
    }

    public Object dequeue() throws Exception {
        if (isEmpty())
            throw new Exception();
        Object x = head.info;
        head = head.next;
        if (head == null)
            tail = null;
        return (x);
    }

    public void enqueue(Object x) {
        if (isEmpty())
            head = tail = new Node(x);
        else {
            tail.next = new Node(x);
            tail = tail.next;
        }
    }

    public void toStringQueue() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.info);
            temp = temp.next;
        }
    }
    
}
