public class Node
{
    private int data;
    private int height;
    private Node left;
    private Node right;
    /**
         * @param a A default integer value to the node.
         */
    public Node(int a)
    {
        data = a;
        height = 1;
        left = null;
        right = null;
    }
    /**
         * @return Returns the value in the node.
         */
    public int data()
    {
        return data;
    }
    /**
         * @param a A given value to the node.
         */
    public void data(int a)
    {
        data = a;
    }
    /**
         * @return Returns the left child of the node.
         */
    public Node left()
    {
        return left;
    }
    /**
         * @param n A given node.
         */
    public void left(Node n)
    {
        left = n;
    }
    /**
         * @return Returns the right chilf of the node.
         */
    public Node right()
    {
        return right;
    }
    /**
         * @param n A given node.
         */
    public void right(Node n)
    {
        right = n;
    }
    /**
         * @return Returns the height of the node.
         */
    public int height()
    {
        return height;
    }
    /**
         * @param a A given integer value to be the new height of the node.
         */
    public void height (int a)
    {
        height = a;
    }
}
