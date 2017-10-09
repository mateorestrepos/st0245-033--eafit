public class Node
{
    private int data;
    private Node head, tail;
    public Node(int data)
    {
    	head = null;
    	tail = null;
    	this.data = data;
    }
    /**
     * Asigna un nuevo valor al dato en el nodo.
     * @param a Un entero cuyo valor le sera asignado al dato en el nodo.
     */
    public void data(int a)
    {
        data = a;
    }
    /**
     * Asigna una cabeza al nodo.
     * @param n Un nodo que sera la nueva cabeza del nodo preestablecido.
     */
    public void head(Node n)
    {
        head = n;
    }
    /**
     * Asigna una cola al nodo.
     * @param n Un nodo que sera la nueva cola del nodo preestablecido.
     */
    public void tail(Node n)
    {
        tail = n;
    }
    /**
     * Retorna el dato contenido en el nodo.
     * @return Retorna el dato contenido en el nodo.
     */
    public int data()
    {
        return data;
    }
    /**
     * Retorna la cabeza del nodo.
     * @return Retorna la cabeza del nodo.
     */
    public Node head()
    {
        return head;
    }
    /**
     * Retorna la cola del nodo.
     * @return Retorna la cola del nodo.
     */
    public Node tail()
    {
        return tail;
    }
}
