import java.util.Stack;

public class StackQueue {
    private Stack<Integer> s1 = new Stack<>(); 
    private Stack<Integer> s2 = new Stack<>(); 

    
    public void enqueue(int x) {
        while (!s1.isEmpty()) s2.push(s1.pop());
        s1.push(x);
        while (!s2.isEmpty()) s1.push(s2.pop());
    }

    
    public int dequeue() {
        if (s1.isEmpty()) throw new RuntimeException("Queue is empty");
        return s1.pop();
    }

    public int peek() {
        if (s1.isEmpty()) throw new RuntimeException("Queue is empty");
        return s1.peek();
    }

    public boolean isEmpty() { return s1.isEmpty(); }
    public int size() { return s1.size(); }

    public static void main(String[] args) {
        StackQueue q = new StackQueue();
        q.enqueue(10); q.enqueue(20); q.enqueue(30);
        System.out.println(q.dequeue()); 
        System.out.println(q.peek());    
        System.out.println(q.size());    
    }
}
