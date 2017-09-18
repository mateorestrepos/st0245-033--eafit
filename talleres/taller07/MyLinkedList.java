// Usar esto cuando se salga el índice
import java.lang.IndexOutOfBoundsException; 
// Una lista simplemente enlazada
public class MyLinkedList {
    public Node first;
    private int size;
    public MyLinkedList()
    {
        size = 0;
        first = null;   
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     */
    public int get(int index) {
        Node temp = null;
        try {
            temp = getNode(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.exit(0);
        }

        return temp.data;
    }
    // Retorna el tamaño actual de la lista
    public int size()
    {
        return size;
    }
    
    // Inserta un dato en la posición index
    public void insert(int data, int index) throws IndexOutOfBoundsException
    {
        Node temp = first;
        Node nuevo = new Node(data);
        if(temp==null){
            first=nuevo;
            size++;
        }
        else if (index >= 0 && index <= size) {
            for(int i = 1;i < index -1;i++){
                temp = temp.next;
            }
            nuevo.next = temp.next;
            temp.next = nuevo;
            size++;
        } else {
            throw new IndexOutOfBoundsException();
        }

    }
    // Borra el dato en la posición index
    public void remove(int index)
    {
        if (index >= 0 && index < size)
        {
            Node temp = first;
            for(int i = 0;i < index-1;i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    // Verifica si está un dato en la lista
    public boolean contains(int data)
    {
        for(int i = 1 ;i< size;i++){
            if(get(i)==data) return true;
        }
        return false;
    }
    
}
