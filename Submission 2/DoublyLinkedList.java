public class DoublyLinkedList {
    private class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    private Node head, tail;
    private int size;

    public void addFirst(int x) {
        Node n = new Node(x);
        if (head == null) head = tail = n;
        else {
            n.next = head;
            head.prev = n;
            head = n;
        }
        size++;
    }

    public void addLast(int x) {
        Node n = new Node(x);
        if (tail == null) head = tail = n;
        else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        size++;
    }

    public void insertAt(int index, int x) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) { addFirst(x); return; }
        if (index == size) { addLast(x); return; }
        Node cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        Node n = new Node(x);
        n.prev = cur.prev;
        n.next = cur;
        cur.prev.next = n;
        cur.prev = n;
        size++;
    }

    public int removeFirst() {
        if (head == null) throw new RuntimeException("List is empty");
        int val = head.data;
        head = head.next;
        if (head == null) tail = null;
        else head.prev = null;
        size--;
        return val;
    }

    public int removeLast() {
        if (tail == null) throw new RuntimeException("List is empty");
        int val = tail.data;
        tail = tail.prev;
        if (tail == null) head = null;
        else tail.next = null;
        size--;
        return val;
    }

    public boolean remove(int x) {
        Node cur = head;
        while (cur != null && cur.data != x) cur = cur.next;
        if (cur == null) return false;
        if (cur == head) removeFirst();
        else if (cur == tail) removeLast();
        else {
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            size--;
        }
        return true;
    }

    public int size() { return size; }

    public void displayForward() {
        for (Node cur = head; cur != null; cur = cur.next)
            System.out.print(cur.data + " <-> ");
        System.out.println("null");
    }

    public void displayBackward() {
        for (Node cur = tail; cur != null; cur = cur.prev)
            System.out.print(cur.data + " <-> ");
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast(1); list.addLast(2); list.addFirst(0);
        list.insertAt(2, 99);
        list.displayForward();   
        list.displayBackward();  
        list.remove(99);
        list.displayForward();   
    }
}
