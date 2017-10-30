/**
 * @author Manish Bhojasia
 * 
 * @author Nicolas Restrepo Lopez
 * @author Mateo Restrepo Sierra
 */
public class AVL_Tree
{
    private Node root;
    private int height(Node n)
    {
        if (n == null)
            return 0;
        else
            return n.height;
    }
    private Node rotateRight(Node n)
    {
        Node x = n.right;
        n.right = x.left;
        x.left = n;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        x.height = Math.max(height(x.right), n.height) + 1;
        return x;
    }
    private Node rotateLeft(Node n)
    {
        Node x = n.left;
        n.left = x.right;
        x.right = n;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        x.height = Math.max(height(x.left), n.height) + 1;
        return x;
    }
     private Node doubleLeft(Node n)
        {
         n.left = rotateRight(n.left);
         return rotateLeft(n);
    } 
     private Node doubleRight(Node n)
     {
         n.right = rotateLeft(n.right);
         return rotateRight(n);
     }  
    private int balance(Node n)
    {
        if (n == null)
            return 0;
        else
            return height(n.left) - height(n.right);
    }
    /**
         * @param t A given Thingy to insert into the tree.
         * @see AVL_Tree#insert(Thingy, Node)
         */
    public void insert(Thingy t)
    {
        root = insert(t, root);
    }
    private Node insert(Thingy t, Node n)
    {
        if (n == null)
            return new Node(t);
        else if (t.data <= n.t.data)
        {
            n.left = insert(t, n.left);
            if(height(n.left) - height(n.right) == 2)
                if(t.data <= n.left.t.data )
                    n = rotateLeft(n);
                else
                    n = doubleLeft(n);
        }
        else if (t.data > n.t.data)
        {
            n.right = insert(t, n.right);
            if( height(n.right) - height(n.left) == 2 )
                 if(t.data > n.right.t.data)
                     n = rotateRight(n);
                 else
                     n = doubleRight(n);
        }
        n.height = Math.max(height(n.left), height(n.right) + 1);
        return n;
    }
    /**
         * @param t A given Thingy to delete from the tree.
         * @see AVL_Tree#delete(Thingy, Node)
         */
    public void delete(Thingy t)
    {
        root = delete(t, root);
    }
    private Node left(Node n)
    {
        Node x = n;
        while (x.left != null)
        {
            x = x.left;
        }
        return x;
    }
    private Node right(Node n)
    {
        Node x = n;
        while (x.right != null)
        {
            x = x.right;
        }
        return x;
    }
    private Node delete(Thingy t, Node n)
    {
        if (n == null)
            return n;
        if (t.data < n.t.data)
            n.left = delete(t, n.left);
        else if (t.data > n.t.data)
            n.right = delete(t, n.right);
        else 
        {
            if (n.left == null || n.right == null)
            {
                Node x = null;
                if (x == n.left)
                    x = n.right;
                else
                    x = n.left;
                if (x == null)
                {
                    //x = n;
                    n = null;
                }
                else
                    n = x;
            }
            else
            {
                Node x = left(n.right);
                n.t.data = x.t.data;
                n.right = delete(x.t, n.right);
            }
        }
        if (n == null)
            return n;
        n.height = Math.max(height(n.left), height(n.right) + 1);
        int a = balance(n);
        if (a > 1 && balance(n.left) >= 0)
            return rotateRight(n);
        if (a < -1 && balance(n.left) <= 0)
            return rotateLeft(n);
        if (a > 1 && balance(n.left) < 0)
        {
            n.left = rotateLeft(n.left);
            return rotateRight(n);
        }
        if (a < -1 && balance(n.left) > 0)
        {
            n.right = rotateRight(n.right);
            return rotateLeft(n);
        }
        return n;
    }
    /**
         * @param data A given integer to search in the tree.
         * @return Returns whether data is in the tree or not.
         * @see AVL_Tree#search(int, Node)
         */
    public String search(int data)
    {
        return search(data, root);
    }
    private String search(int data, Node n)
    {
        String found = null;
        while (n != null)
        {
            if (data < n.t.data)
                n = n.left;
            else if (data > n.t.data)
                n = n.right;
            else 
            {
                found = n.t.directory;
                break;
            }
            found = search(data, n);
        }
        return found;
    }
    /**
         * @param data A given integer to search in the tree.
         * @return Returns whether data is in the tree or not.
         * @see AVL_Tree#searchThingy(int)
         */
    public Thingy searchThingy(int data)
    {
        return searchThingy(data, root);
    }
    private Thingy searchThingy(int data, Node n)
    {
        Thingy found = null;
        while (n != null && !false)
        {
            if (data < n.t.data)
                n = n.left;
            else if (data > n.t.data)
                n = n.right;
            else 
            {
                found = n.t;
                break;
            }
            found = searchThingy(data, n);
        }
        return found;
    }
    private int makeInt(String s)
    {
        s = s.toUpperCase();
        if (s.contains("K"))
        {
            s = s.substring(0, s.indexOf("K"));
            float a = Float.parseFloat(s);
            return (int) (a * 1024);
        }
        else if (s.contains("M"))
        {
            s = s.substring(0, s.indexOf("M"));
            float a = Float.parseFloat(s);
            return (int) (a * Math.pow(1024, 2));
        }
        else if (s.contains("G"))
        {
            s = s.substring(0, s.indexOf("G"));
            float a = Float.parseFloat(s);
            return (int) (a * Math.pow(1024, 3));
        }
        else if (s.equals(".*\\d.*"));
        {
            try
            {
                float a = Float.parseFloat(s);
                return (int) (a);
            }
            catch (NumberFormatException e)
            {
                return -1;
            }
        }
    }
    /**
         * @param s A given minimum size from which search will be done in the tree.
         * @see AVL_Tree#printRange(Node, int, int, int)
         */
    public void printHigher(String s)
    {
        int min = makeInt(s);
        int max = right(root).t.data;
        if (min >= 0)
            printRange(root, min, max, 0);
        else
            System.out.println("Wrong input");
    }
    /**
         * @param s A given maximum size up to search will be done in the tree.
         * @see AVL_Tree#printRange(Node, int, int, int)
         */
    public void printLower(String s)
    {
        int max = makeInt(s);
        if (max >= 0)
            printRange(root, 0, max, 0);
        else
            System.out.println("Wrong input");
    }
    private void printRange(Node n, int min, int max, int found) 
    {
        if (n == null)
            return;
        if (min < n.t.data)
            printRange(n.left, min, max, found);
        if (min <= n.t.data && max >= n.t.data)
        {
            found++;
            System.out.println(n.t.name);
        }
        if (max > n.t.data)
        {
            printRange(n.right, min, max, found);
        }
    }
    /**
         * @param s1 A given minimum size from which search will be done in the tree.
         * @param s2 A given maximum size up to search will be done in the tree.
         * @see AVL_Tree#printRange(Node, int, int, int)
         */
    public void printRange(String s1, String s2)
    {
        int min = makeInt(s1);
        int max = makeInt(s2);
        if (min >= 0 && max >= 0)
            printRange(root, min, max, 0);
        else
            System.out.println("Wrong input");
    }
}
