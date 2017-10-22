public class Punto2
{
    Node root ;
    public Punto2 ()
    {
        root = null ;
    }
    public void insertar(int n) 
    {
        root = insertar(root,n);
    } 
    private Node insertar(Node nodo, int n)
    {
        if(nodo==null)
            return new Node(n);
        else if(nodo.intData < n)
        {
            nodo.right= insertar(nodo.right, n);
            return nodo; 
        } 
        nodo.left = insertar(nodo.left,n);
        return nodo;
    }
    public void posOrden()
    {
        posOrden(root);
    }
    public void posOrden(Node n)
    {
        if (n != null)
        {
            posOrden(n.left);
            posOrden(n.right);
            System.out.print(n.intData + " ");
        }
    }
    public static void main(String [] args)
    {
        Punto2 ejemplo = new Punto2();
        
        ejemplo.insertar(50);
        ejemplo.insertar(30);
        ejemplo.insertar(24);
        ejemplo.insertar(5);
        ejemplo.insertar(28);
        ejemplo.insertar(45);
        ejemplo.insertar(98);
        ejemplo.insertar(52);
        ejemplo.insertar(60);
        
        ejemplo.posOrden();
    }
}
