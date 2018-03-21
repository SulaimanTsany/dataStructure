public class QueueNode<E> {
  private NodeSLL<E> head, tail;
  public QueueNode () {}
  public QueueNode (E data) {
    head = new NodeSLL(data);
    tail = head.next;
  }
  public void show () {
    NodeSLL<E> pointer = head;
    while (pointer!=null) {
      System.out.print(pointer.data+" ");
      pointer = pointer.next;
    }
  }
  public boolean isEmpty () {
      if (head == null) {
          return true;
      }
      return false;
  }
  public void enqueue(E data) {
    NodeSLL<E> newNode = new NodeSLL(data);
    if (tail == null) {
        tail = new NodeSLL(data);
        head = tail;
        return;
    }
    tail.next = newNode;
    tail = newNode;
  }

  public E dequeue () {
      if (head == null) {
          return null;
      }
      NodeSLL<E> newHead = head.next;
      NodeSLL<E> temp = head;
      head = null;
      head = newHead;
      return temp.data;
  }
  /*
  public void enqueue (E data) {
    NodeSLL<E> newNode = new NodeSLL(data);
    if (head == null) {
        head = new NodeSLL(data);
        return;
    }
    NodeSLL<E> pointer = head;
    while (pointer.next != null) {
        pointer = pointer.next;
    }
    pointer.next = newNode;
  }
  */
}
