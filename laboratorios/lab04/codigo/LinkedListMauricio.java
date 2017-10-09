import java.lang.IndexOutOfBoundsException;
// Una lista doblemente enlazada
public class LinkedListMauricio 
{
    private Node first, last;
    private int size;
    public LinkedListMauricio()
    {
        size = 0;
        first = null;   
        last = null;
    }
    /**
    * Retorna el nodo en la posicion indicada en la lista.
    * @param index Indice del nodo a retornar.
    * @return Retorna el nodo en la posicion indicada
    * @throws IndexOutOfBoundsException
    */
    private Node getNode(int index) throws IndexOutOfBoundsException 
    {
        if (index >= 0 && index < size) 
        {
            if (index <= size / 2) //Traverses list from head to size / 2 element
            {
                Node temp = first;
                for (int i = 0; i < index; i++) 
                {
                    temp = temp.tail();
                }
                return temp;
            }
            else //Traverses list from tail to size / 2 element
            {
                Node temp = last;
                for (int i = size - 1; i > index; i--) 
                {
                    temp = temp.head();
                }
                return temp;
            }
        } 
        else 
        {
            throw new IndexOutOfBoundsException();
        }
    }
    /**
    * Retorna el elemento en la posicion indicada de la lista.
    * @param index Indice del elemento a retornar.
    * @return Retorna el elemento en la posicion indicada.
    */
    public int get(int index) 
    {
        Node temp = null;
        try 
        {
            temp = getNode(index);
        } 
        catch (IndexOutOfBoundsException e) 
        {
            e.printStackTrace();
            System.exit(0);
        }
        return temp.data();
    }
    // Retorna el tamaño actual de la lista
    /**
    * Retorna el tamaño de la lista.
    * @return Retorna el tamaño de la lista.
    */
    public int size()
    {
        return size;
    }
    // Inserta un dato en la posición index
    /**
    * Inserta un elemento en una posicion dada.
    * @param data Elemento a insertar en la lista.
    * @param index Posicion en la cual se va a insertar el elemento.
    * @throws IndexOutOfBoundsException.
    */
    public void insert(int data, int index) throws IndexOutOfBoundsException
    {
        if (index >= 0 && index <= size) 
        {
            if (size == 0 && index == 0)
            {
                first = new Node(data);
                last = first;
                size++;
            }
            else if (index == 0 && size != 0)
            {
                Node temp = first;
                Node aux = new Node(data);
                first = aux;
                first.tail(temp);
                temp.head(first);
                size++;
            }
            else if (size != 0 && index < size)
            {
                Node temp = first;
                for (int i = 0; i < index; i++)
                {
                    temp = temp.tail();
                    if (i == index - 1)
                    {
                        Node aux = temp.head();
                        Node n = new Node(data);
                        n.tail(temp);
                        temp.head(n);
                        aux.tail(n);
                        n.head(aux);
                    }
                }
                size++;
            }
            else if (index == size && size != 0)
            {
                Node temp = last;
                Node aux = new Node(data);
                last = aux;
                last.head(temp);
                temp.tail(last);
                size++;
            }
        } 
        else 
        {
            throw new IndexOutOfBoundsException();
        }
    }
    // Borra el dato en la posición index
    /**
    * Elimina un elemento de la lista.
    * @param index Posicion del elemento a eliminar.
    * @throws IndexOutOfBoundsException
    */
    public void remove(int index) throws IndexOutOfBoundsException
    {
        if (index < size) 
        {
            if (index == 0)
            {
                first = first.tail();
                first.head(null);
            }
            else if (index == size - 1)
            {
                last = last.head();
                last.tail(null);
            }
            else
            {
                Node temp = first;
                for (int i = 0; i < index; i++)
                {
                    if (i == index - 1)
                    {
                        Node aux = temp.tail();
                        temp.tail(aux.tail());
                        temp.tail().head(temp);
                    }
                    else
                        temp = temp.tail();
                }
            }
            size--;
        } 
        else 
        {
            throw new IndexOutOfBoundsException();
        }
    }
    // Verifica si está un dato en la lista
    /**
    * Retorna si un elemento esta en la lista.
    * @param data Elemento a buscar en la lista.
    * @return Retorna si el elemento esta en la lista.
    */
    public boolean contains(int data)
    {
        boolean contains = false;
        for (int i = 0; i < size; i++)
        {
            if (get(i) == data)
            {
                contains = true;
                break;
            }
        }
        return contains;
    }
}