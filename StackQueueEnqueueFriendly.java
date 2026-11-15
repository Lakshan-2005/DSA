
public class StackQueueEnqueueFriendly {

    private static class Stack {
        private int[] data = new int[4];
        private int size;
        void push(int x) {
            if (size == data.length) {
                int[] c = new int[size * 2];
                for (int i = 0; i < size; i++) c[i] = data[i];
                data = c;
            }
            data[size++] = x;
        }
        int pop() { return data[--size]; }
        boolean isEmpty() { return size == 0; }
        int size() { return size; }
    }

    private Stack s1 = new Stack();
    private Stack s2 = new Stack(); 

    public void enqueue(int x) {              
        s1.push(x);
    }

    public int dequeue() {                   
        if (s1.isEmpty()) throw new RuntimeException("Queue is empty");
        while (s1.size() > 1) s2.push(s1.pop());
        int front = s1.pop();                  
        while (!s2.isEmpty()) s1.push(s2.pop());
        return front;
    }

    public boolean isEmpty() { return s1.isEmpty(); }

    public static void main(String[] args) {
        StackQueueEnqueueFriendly q = new StackQueueEnqueueFriendly();
        q.enqueue(1); q.enqueue(2); q.enqueue(3);
        System.out.println(q.dequeue()); 
        System.out.println(q.dequeue()); 
        q.enqueue(4);
        System.out.println(q.dequeue()); 
        System.out.println(q.dequeue());
    }
}
