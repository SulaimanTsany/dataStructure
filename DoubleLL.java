public class DoubleLL {
    private Node head;
    private Node tail;
    private int size;

    DoubleLL () {
        size = 0;
        this.head = null;
        this.tail = null;
    }
    DoubleLL (Node node) {
        this.head = node;
        this.tail = node;
        head.previous = null;
        tail.next = null;
    }
    public Node getHead () {
        System.out.println("Head= "+head.data);
        return this.head;
    }
    public Node getTail () {
        System.out.println("Tail= "+tail.data);
        return this.tail;
    }
    public void showFromHead () {
        Node node = this.head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    public void showFromTail () {
        Node node = this.tail;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.previous;
        }
    }
    public Node add (int data) {
        Node newNode = new Node(data);
        newNode.previous = tail;
        newNode.next = null;
        if (this.tail == null) {
            Node tail = new Node(data);
            return tail;
        }
        tail.next = newNode;
        tail = newNode;
        return tail;
    }
    public Node add (int data, int position) {
        int index = 0;
        if (position == 0) {
            return addHead(data);
        } else {
            Node pointer = head;
            for (int i=1; i<position; i++) {
                pointer = pointer.next;
                if (pointer == null) {
                    System.out.println("Index out of bound");
                    return this.head;
                }
            }
            Node temp = pointer.next;
            Node newNode = new Node(data);
            pointer.next = newNode;
            temp.previous = newNode;
            newNode.previous = pointer;
            newNode.next = temp;
        }
        return this.head;
    }
    public Node addHead (int data) {
        Node newNode = new Node(data);
        newNode.previous = null;
        newNode.next = this.head;
        head.previous = newNode;
        this.head = newNode;
        return this.head;
    }
    public boolean search (int data) {
        Node pointer = this.head;
        while (pointer != null) {
            if (pointer.data == data) {
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }
    public boolean searchFromTail (int data) {
        Node pointer = this.tail;
        while (pointer != null) {
            if (pointer.data == data) {
                return true;
            }
            pointer = pointer.previous;
        }
        return false;
    }
    public int searchIndex (int data) {
        int index = 0;
        Node pointer = this.head;
        while (pointer != null) {
            System.out.println(pointer.data);
            if (pointer.data == data) {
                return index;
            }
            pointer = pointer.next;
            index++;
        }
        return (-1);
    }
    public Node removeHead () {
        head = head.next;
        head.previous = null;
        return head;
    }
    public Node removeTail () {
        tail = tail.previous;
        tail.next = null;
        return tail;
    }
    public Node remove (int position) {
        int index = 0;
        if (position == 0) {
            return removeHead();
        } else {
            Node pointer = head;
            for (int i=1; i<position; i++) {
                pointer = pointer.next;
                if (pointer == null) {
                    System.out.println("Index out of bound");
                    return this.head;
                }
            }
            Node temp = pointer.next.next;
            pointer.next = temp;
            temp.previous = pointer;
        }
        return head;
    }
    public int size () {
        size = 0;
        Node pointer = this.head;
        while (pointer != null) {
            pointer = pointer.next;
            size++;
        }
        return size;
    }
}


class Node {
    Node next;
    Node previous;
    int data;
    Node (int data) {
        this.data = data;
    }
    Node () {}
}
