public class StackNode<E> {
    private NodeSLL<E> top;
    private int size;
    public StackNode () {}
    public int size () {
        NodeSLL<E> pointer = top;
        this.size = 0;
        while (pointer != null) {
            pointer = pointer.next;
            size++;
        }
        return size;
    }
    public boolean isEmpty () {
        if (top == null) {
            return true;
        }
        return false;
    }
    public void show () {
        NodeSLL<E> pointer = top;
        while (pointer != null) {
            System.out.print(pointer.data+" ");
            pointer = pointer.next;
        }
    }
    public E pop () {
        if (top == null) {
            return null;
        }
        NodeSLL<E> temp = top;
        top = temp.next;
        return temp.data;
    }
    public void push (E data) {
        if (top == null) {
            top = new NodeSLL(data);
            return;
        }
        NodeSLL<E> newTop = new NodeSLL(data);
        newTop.next = top;
        top = newTop;
    }
}
