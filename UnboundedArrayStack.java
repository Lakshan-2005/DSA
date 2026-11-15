
public class UnboundedArrayStack {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data = new int[INITIAL_CAPACITY];
    private int size = 0;

    public void push(int x) {
        if (size == data.length) resize(data.length * 2);
        data[size++] = x;
    }

    public int pop() {
        if (size == 0) throw new RuntimeException("Stack is empty");
        int val = data[--size];
        if (data.length > INITIAL_CAPACITY && size <= data.length / 4)
            resize(data.length / 2);
        return val;
    }

    public int peek() {
        if (size == 0) throw new RuntimeException("Stack is empty");
        return data[size - 1];
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }
    public int capacity() { return data.length; }

    private void resize(int newCapacity) {
        int[] copy = new int[newCapacity];
        for (int i = 0; i < size; i++) copy[i] = data[i];
        data = copy;
        System.out.println("  [resized to " + newCapacity + "]");
    }

    public static void main(String[] args) {
        UnboundedArrayStack s = new UnboundedArrayStack();
        for (int i = 1; i <= 20; i++) s.push(i);
        System.out.println("Size " + s.size() + ", capacity " + s.capacity());
        while (s.size() > 2) s.pop();
        System.out.println("Size " + s.size() + ", capacity " + s.capacity());
        System.out.println("Top: " + s.peek());
    }
}
