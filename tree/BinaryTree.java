public class BinaryTree {
    public static void main (String[] args) {
        BinaryTree tree = new BinaryTree(10);
        tree.add(6);
        tree.add(5);
        tree.add(4);
        tree.add(7);
        Node nt = tree.getRoot();
        preOrder(nt);
        System.out.println();
        nt = leftRotate(nt);
        preOrder(nt);

    }
    private Node root;
    public BinaryTree (int data) {
        root = new Node(data);
    }
    public void add (int data) {
        root = addRecursive(root, data);
    }
    public void print () {
        inOrder(root);
    }
    public Node getRoot () {
        return root;
    }
    private Node addRecursive (Node pointer, int data) {
        if (pointer == null) {
            return new Node(data);
        }
        if (pointer.data > data) {
            pointer.left = addRecursive(pointer.left, data);
        } else {
            pointer.right = addRecursive(pointer.right, data);
        }
        return pointer;
    }
    private void postOrder (Node pointer) {
        if (pointer == null) {
            return;
        }
        postOrder(pointer.left);
        postOrder(pointer.right);
        System.out.print(pointer.data + " ");
    }
    private void inOrder (Node pointer) {
        if (pointer == null) {
            return;
        }
        inOrder(pointer.left);
        System.out.print(pointer.data + " ");
        inOrder(pointer.right);
    }
    public static void preOrder (Node pointer) {
        if (pointer == null) {
            return;
        }
        System.out.print(pointer.data + " ");
        preOrder(pointer.left);
        preOrder(pointer.right);
    }
    public static Node leftRotate (Node pivot) {
        Node y = pivot.left;
        Node t2 = y.right;
        y.right = pivot;
        pivot.left = t2;
        return y;
    }
    private Node rightRotate (Node pivot) {
        return null;
    }
}

class Node {
    public Node left;
    public Node right;
    public int data;
    public Node (int data) {
        this.data = data;
    }
}
