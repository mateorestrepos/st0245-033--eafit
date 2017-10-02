public class AVL_Tree
{
    private Node root;
    /**
         * @param n A given node.
         * @return Returns the height of the node.
         * @see AVL_Tree#rotateL(Node)
         * @see AVL_Tree#rotateR(Node)
         * @see AVL_Tree#balance(Node)
         * @see AVL_Tree#insert(int, Node)
         * @see AVL_Tree#delete(int, Node)
         */
    public int height(Node n)
    {
        if (n == null)
            return 0;
        else
            return n.height();
    }
    /**
         * @param n A given node.
         * @return Returns a rotated node.
         * @see AVL_Tree#insert(int, Node)
         * @see AVL_Tree#delete(int, Node)
         */
    public Node rotateR(Node n)
    {
        Node x = n.left();
        Node y = x.right();
        x.right(n);
        n.left(y);
        n.height(Math.max(height(n.left()), height(n.right()) + 1));
        x.height(Math.max(height(x.left()), height(x.right()) + 1));
        return x;
    }
    /**
         * @param n A given node.
         * @return Returns a rotated node.
         * @see AVL_Tree#insert(int, Node)
         * @see AVL_Tree#delete(int, Node)
         */
    public Node rotateL(Node n)
    {
        Node x = n.right();
        Node y = x.left();
        x.left(n);
        n.right(y);
        n.height(Math.max(height(n.left()), height(n.right()) + 1));
        x.height(Math.max(height(x.left()), height(x.right()) + 1));
        return x;
    }
    /**
         * @param n A given node.
         * @return The difference between the height of node n childs.
         * @see AVL_Tree#insert(int, Node)
         * @see AVL_Tree#delete(int, Node)
         */
    public int balance(Node n)
    {
        if (n == null)
            return 0;
        else
            return height(n.left()) - height(n.right());
    }
    /**
         * @param data A given integer to insert into the tree.
         * @see AVL_Tree#insert(int, Node)
         */
    public void insert(int data)
    {
        root = insert(data, root);
    }
    /**
         * @param data A given integer to insert into the tree.
         * @param n A given node.
         * @return Returns a node with data inserted into it.
         * @see AVL_Tree#insert(int)
         */
    public Node insert(int data, Node n)
    {
        if (n == null)
            return new Node(data);
        if (data < n.data())
            n.left(insert(data, n.left()));
        else if (data > n.data())
            n.right(insert(data, n.right()));
        else 
            return n;
        n.height(Math.max(height(n.left()), height(n.right()) + 1));
        int a = balance(n);
        if (a > 1 && data < n.left().data())
            return rotateR(n);
        if (a < -1 && data > n.right().data())
            return rotateL(n);
        if (a > 1 && data > n.left().data())
        {
            n.left(rotateL(n.left()));
            return rotateR(n);
        }
        if (a < -1 && data < n.left().data())
        {
            n.right(rotateR(n.right()));
            return rotateL(n);
        }
        return n;
    }
    /**
         * @param data A given integer to delete from the tree.
         * @see AVL_Tree#delete(int, Node)
         */
    public void delete(int data)
    {
        root = delete(data, root);
    }
    /**
         * @param n A given node.
         * @return Returns the leftmost node.
         * @see AVL_Tree#delete(int, Node)
         */
    public Node left(Node n)
    {
        Node x = n;
        while (x.left() != null)
        {
            x = x.left();
        }
        return x;
    }
    /**
         * @param data A given integer to delete from the tree.
         * @param n A given node.
         * @return Returns a node with data deleted.
         * @see AVL_Tree#delete(int)
         */
    public Node delete(int data, Node n)
    {
        if (n == null)
            return n;
        if (data < n.data())
            n.left(delete(data, n.left()));
        else if (data > n.data())
            n.right(delete(data, n.right()));
        else 
        {
            if (n.left() == null || n.right() == null)
            {
                Node x = null;
                if (x == n.left())
                    x = n.right();
                else
                    x = n.left();
                if (x == null)
                {
                    x = n;
                    n = null;
                }
                else
                    n = x;
            }
            else
            {
                Node x = left(n.right());
                n.data(x.data());
                n.right(delete(x.data(), n.right()));
            }
        }
        if (n == null)
            return n;
        n.height(Math.max(height(n.left()), height(n.right()) + 1));
        int a = balance(n);
        if (a > 1 && balance(n.left()) >= 0)
            return rotateR(n);
        if (a < -1 && balance(n.left()) <= 0)
            return rotateL(n);
        if (a > 1 && balance(n.left()) < 0)
        {
            n.left(rotateL(n.left()));
            return rotateR(n);
        }
        if (a < -1 && balance(n.left()) > 0)
        {
            n.right(rotateR(n.right()));
            return rotateL(n);
        }
        return n;
    }
    /**
         * @param data A given integer to search in the tree.
         * @return Returns whether data is in the tree or not.
         * @see AVL_Tree#search(int, Node)
         */
    public boolean search(int data)
    {
        return search(data, root);
    }
    /**
         * @param data A given integer to search the tree.
         * @return Returns whether data is in the tree or not.
         * @see AVL_Tree#search(int)
         */
    public boolean search(int data, Node n)
    {
        boolean found = false;
        while (n != null && !false)
        {
            if (data < n.data())
                n = n.left();
            else if (data > n.data())
                n = n.right();
            else 
            {
                found = true;
                break;
            }
            found = search(data, n);
        }
        return found;
    }
    /**
         * @see AVL_Tree#printTree(Node)
         */
    public void printTree()
    {
        printTree(root);
    }
    /**
         * @param n A given node.
         * @see AVL_Tree#printTree()
         */
    public void printTree(Node n)
    {
        if (n != null)
        {
            System.out.print(n.data() + " ");
            printTree(n.left());
            printTree(n.right());
        }
    }
    /**
         * @see AVL_Tree#printSortedTree(Node)
         */
    public void printSortedTree()
    {
        printSortedTree(root);
    }
    /**
         * @param n A given node.
         * @see AVL_Tree#printSortedTree()
         */
    public void printSortedTree(Node n)
    {
        if (n != null)
        {
            printSortedTree(n.left());
            System.out.print(n.data() + " ");
            printSortedTree(n.right());
        }
    }
    public static void main (String [] args)
    {
        AVL_Tree example = new AVL_Tree();
        example.insert(6);
        example.insert(2);
        example.insert(7);
        example.insert(4);
        example.insert(3);
        example.insert(0);
        example.insert(8);
        example.insert(1);
        example.insert(9);
        example.insert(5);
        
        System.out.print("Traversal of constructed tree is: ");
        example.printTree();
        System.out.println();
        System.out.print("Traversal of sorted constructed tree is: ");
        example.printSortedTree();
        
        example.delete(4);
        System.out.println();
        System.out.println();
        System.out.print("Traversal of constructed tree after deleting '4' is: ");
        example.printTree();
        System.out.println();
        System.out.print("Traversal of constructed sorted tree after deleting '4' is: ");
        example.printSortedTree();
        
        System.out.println();
        System.out.println();
        System.out.println("Searching for '7': " + example.search(7));
        System.out.println("Searching for '4': " + example.search(4));
    }
}