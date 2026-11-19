public class SinglyLinkedList {
    private class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;
    private int size;

    public void addFirst(int x) {
        Node n = new Node(x);
        n.next = head;
        head = n;
        size++;
    }

    public void addLast(int x) {
        Node n = new Node(x);
        if (head == null) head = n;
        else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = n;
        }
        size++;
    }

    public void insertAt(int index, int x) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) { addFirst(x); return; }
        Node cur = head;
        for (int i = 0; i < index - 1; i++) cur = cur.next;
        Node n = new Node(x);
        n.next = cur.next;
        cur.next = n;
        size++;
    }

    public int removeFirst() {
        if (head == null) throw new RuntimeException("List is empty");
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (head == null) throw new RuntimeException("List is empty");
        if (head.next == null) return removeFirst();
        Node cur = head;
        while (cur.next.next != null) cur = cur.next;
        int val = cur.next.data;
        cur.next = null;
        size--;
        return val;
    }

    public boolean remove(int x) {
        if (head == null) return false;
        if (head.data == x) { removeFirst(); return true; }
        Node cur = head;
        while (cur.next != null && cur.next.data != x) cur = cur.next;
        if (cur.next == null) return false;
        cur.next = cur.next.next;
        size--;
        return true;
    }

    public boolean contains(int x) {
        for (Node cur = head; cur != null; cur = cur.next)
            if (cur.data == x) return true;
        return false;
    }

    public void reverse() {
        Node prev = null, cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }

    public int size() { return size; }

    public void display() {
        for (Node cur = head; cur != null; cur = cur.next)
            System.out.print(cur.data + " -> ");
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1); list.addLast(2); list.addFirst(0);
        list.insertAt(2, 99);
        list.display();   
        list.reverse();
        list.display();   
        list.remove(99);
        list.display();   
    }
}
