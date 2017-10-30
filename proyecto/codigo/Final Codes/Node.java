/**
 * @author Nicolas Restrepo Lopez
 * @author Mateo Restrepo Sierra
 */
public class Node
{
    Thingy t;
    int height;
    Node left;
    Node right;
    public Node(Thingy t)
    {
        this.t = t;
        height = 1;
        left = null;
        right = null;
    }
}