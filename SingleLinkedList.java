public class SingleLinkedList<E> {
  private NodeSLL<E> head, tail;
  private int size;
  public SingleLinkedList () {}
  public SingleLinkedList (E data) {
    this.head = new NodeSLL(data);
    tail = head;
    size++;
  }
  public int size () {
    return this.size;
  }
  public NodeSLL getHead () {
      return head;
  }
  public void show () {
    NodeSLL<E> pointer = head;
    while (pointer != null) {
      System.out.print(pointer.data + " ");
      pointer = pointer.next;
    }
  }
  public void showTail (NodeSLL node) {
      if (node == null) {
          return;
      }
      showTail(node.next);
      System.out.print(node.data+" ");
  }
  public void add (E data) {
    if (head == null) {
      head = new NodeSLL(data);
      tail = head;
      size++;
      return;
    }
    NodeSLL<E> newNode = new NodeSLL(data);
    tail.next = newNode;
    tail = tail.next;
    size++;
  }
  public void addHead (E data) {
    if (head == null) {
      head = new NodeSLL(data);
      tail = head;
      size++;
      return;
    }
    NodeSLL<E> newHead = new NodeSLL(data);
    newHead.next = head;
    head = newHead;
    size++;
  }
  public void add (E data, int position) { //sedikit bermasalah
    if (position == 0) {
      addHead(data);
      return;
    }
    else if (position >= size) {
      add(data);
      return;
    }
    NodeSLL<E> pointer = head;
    for (int i=0; i<position-1; i++) {
      pointer = pointer.next;
    }
    NodeSLL<E> temp = pointer.next;
    NodeSLL<E> newNode = new NodeSLL(data);
    pointer.next = newNode;
    newNode.next = temp;
    size++;
  }
  public void removeHead () {
    if (head==null) {
      return;
    }
    NodeSLL<E> newHead = head;
    head = newHead.next;
  }
  public void remove () {
    if (head==null || head.next==null) {
      head = null;
      return;
    }
    NodeSLL<E> pointer = head;
    while (pointer.next!=null) {
      tail = pointer;
      pointer = pointer.next;
    }
    tail.next = null;
    size--;
  }
  public void remove (int position) {
    if (size <= position-1) {
      remove();
      return;
    }
    else if (position == 0) {
      removeHead();
      return;
    }
    NodeSLL<E> pointer = head;
    for (int i=0; i<position-1; i++) {
      pointer = pointer.next;
    }
    NodeSLL<E> temp = pointer.next.next;
    pointer.next = temp;
    size--;
  }
  public void reverse () {
      if (head.next==null || head==null) {
          return;
      }
      NodeSLL<E> newNode = head;
      NodeSLL<E> pointer = head;
      NodeSLL<E> nextNode = pointer.next;
      NodeSLL<E> newHead= head;
      while (nextNode != null) {
          newHead.next = head;
          head = newHead;
          nextNode = nextNode.next;
          pointer = pointer.next;
          System.out.print("aq");
      }
      head = newNode;
  }
}
