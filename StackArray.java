public class StackArray<E> {
  private int size;
  private int top;
  private Object[] array;
  public StackArray (int size) {
    this.size = size;
    array = new Object[size];
    top = -1;
  }
  public E get (int i) {
        final E e = (E) array[i];
        return e;
  }
  public int size () {
    return size;
  }
  public void showAll () {
    for (Object e:array) {
      System.out.print(e+" ");
    }
    System.out.println();
  }
  public void show () {
    for (int i=0; i<=top; i++) {
        System.out.print(array[i]+" ");
    }
    System.out.println();
  }
  public boolean isEmpty () {
    if (top==0 && array[0]==null) {
      return true;
    }
    return false;
  }
  public boolean isFull () {
    if (top==(size-1)) {
      return true;
    }
    return false;
  }
  public E pop () {
    if (top==(-1)) {
      return null;
    }
    E temp = (E) array[top];
    array[top] = null;
    top--;
    return temp;
  }
  public boolean push (E data) {
    if (top==(size-1)) {
      return false;
    }
    array[top+1] = data;
    top++;
    return true;
  }
  /*
  public void setArray() {
    scanner = new Scanner(System.in);
    for (int i=0; i<array.length; i++) {
      array[i] = scanner.nextDouble();    //problem with input type
    }
  }
  */
}
