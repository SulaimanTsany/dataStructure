public class BinaryTree {
    public static void main (String[] args) {
        BinaryTree tree = new BinaryTree(3);
        tree.add(1);
        tree.add(10);
        tree.add(12);
        tree.add(8);
        tree.add(7);
        //tree.add(5);
        //tree.add(4);
        //tree.add(7);
        //tree.print();
        Node nt = tree.getRoot();
        nt = tree.rightLeftRotate(nt);
        tree.preOrder(nt);
        //preOrder(nt);
        //System.out.println();
        //nt = leftRotate(nt);
        //preOrder(nt);

    }
    private Node root;
    public BinaryTree (int data) {
        root = new Node(data);
    }
    public void add (int data) {
        root = addRecursive(root, data);
    }
    public void delete () {
        //root = null;
    }
    public void print () {
        inOrder(root);
    }
    public Node getRoot () {
        //System.out.println("height = "+root.countHeight());
        return root;
    }
    private Node addRecursive (Node pointer, int data) {
        if (pointer == null) {
            return new Node(data);
        }
        int height_left = 0;
        int height_right = 0;
        if (pointer.data > data) {
            pointer.left = addRecursive(pointer.left, data);
            pointer.left.level = pointer.level+1;
        } else {
            pointer.right = addRecursive(pointer.right, data);
            pointer.right.level = pointer.level+1;
        }
        pointer.countHeight();
        pointer.countBlanceFactor();
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
        //System.out.print(pointer.data + "("+ pointer.height+", "+pointer.blanceFactor+") ");
        System.out.print(pointer.data + "("+ pointer.level+") ");
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
    public Node leftLeftRotate (Node pivot) {
        Node temp = pivot;
        Node b = pivot.left;
        if (b.right != null) {
            temp.left = b.right;
        } else {
            temp.left = null;
        }
        b.right = temp;
        return b;
    }
    public Node rightRightRotate (Node pivot) {
        Node temp = pivot;
        Node b = pivot.right;
        if (b.left != null) {
            temp.right = b.left;
        } else {
            temp.right = null;
        }
        b.left = temp;
        return b;
    }
    public Node leftRightRotate (Node pivot) {
        Node b = pivot.left;
        Node c = b.right;
        if (c.right == null) {
            Node temp = c;
            b.right = c.left;
            temp.right = pivot;
            pivot.left = null;
            c.left = b;
        } else if (c.right != null) {
            Node sup = c.right;
            c.right = pivot;
            c.left = b;
            b.right = null;
            pivot.left = sup;
        }
        return c;
    }
    public Node rightLeftRotate (Node pivot) { //belum teruji
        Node b = pivot.right;
        Node c = b.left;
        if (c.left == null) {
            Node temp = c;
            b.left = c.right;
            temp.left = pivot;
            pivot.right = null;
            c.right = b;
        } else if (c.left != null) {
            Node inf = c.left;
            c.left = pivot;
            c.right = b;
            b.left = null;
            pivot.right = inf;
        }
        return c;
    }
}

class Node {
    public Node left;
    public Node right;
    public int data;
    public int blanceFactor;
    public int height;
    public int level;
    public Node (int data) {
        this.data = data;
    }
    public void setRight (Node right) {
        this.right = right;
    }
    public int countHeight () {
        int height_left = 0;
        int height_right = 0;
        if (left != null) {
            height_left += left.height;
        }
        if (right != null) {
            height_right += right.height;
        }
        this.height = height_left+1;
        if (height_right > height) {
            this.height = height_right+1;
        }
        return this.height;
    }
    public int countBlanceFactor () {
        int height_left = 0;
        int height_right = 0;
        if (left != null) {
            height_left = left.height;
        }
        if (right != null) {
            height_right = right.height;
        }
        this.blanceFactor = Math.abs(height_left-height_right);
        return this.blanceFactor;
    }
    public boolean blance () {
        if (blanceFactor>1) {
            return false;
        }
        return true;
    }
}
