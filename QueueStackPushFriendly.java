
public class QueueStackPushFriendly {

    private static class Queue {
        private static class Node { int val; Node next; Node(int v) { val = v; } }
        private Node head, tail;
        private int size;
        void enqueue(int v) {
            Node n = new Node(v);
            if (tail == null) head = tail = n; else { tail.next = n; tail = n; }
            size++;
        }
        int dequeue() {
            int v = head.val;
            head = head.next;
            if (head == null) tail = null;
            size--;
            return v;
        }
        boolean isEmpty() { return size == 0; }
        int size() { return size; }
    }

    private Queue q1 = new Queue();
    private Queue q2 = new Queue();

    public void push(int x) {                  
        q1.enqueue(x);
    }

    public int pop() {                        
        if (q1.isEmpty()) throw new RuntimeException("Stack is empty");
        while (q1.size() > 1) q2.enqueue(q1.dequeue());
        int top = q1.dequeue();
        Queue tmp = q1; q1 = q2; q2 = tmp;
        return top;
    }

    public boolean isEmpty() { return q1.isEmpty(); }

    public static void main(String[] args) {
        QueueStackPushFriendly s = new QueueStackPushFriendly();
        s.push(1); s.push(2); s.push(3);
        System.out.println(s.pop()); 
        System.out.println(s.pop()); 
        s.push(4);
        System.out.println(s.pop()); 
        System.out.println(s.pop()); 
    }
}