public class ArrayCircularQueue {
    private int[] arr;
    private int front, rear, size, capacity;

    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull()  { return size == capacity; }

    public void enqueue(int x) {
        if (isFull()) { System.out.println("Queue is full"); return; }
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        int val = arr[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return arr[front];
    }

    public void display() {
        for (int i = 0; i < size; i++)
            System.out.print(arr[(front + i) % capacity] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayCircularQueue q = new ArrayCircularQueue(4);
        q.enqueue(1); q.enqueue(2); q.enqueue(3); q.enqueue(4);
        q.enqueue(5);               
        q.dequeue();
        q.enqueue(5);              
        q.display();                
    }
}
