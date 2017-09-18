
/**
 * Write a description of class Lab03 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lab03
{
    private static int maximoAux(Node nodo) {
       if(nodo == null) return 0;
       return Math.max(nodo.data, maximoAux(nodo.next));

    }
    public static int maximo(MyLinkedList lista) {
       return maximoAux(lista.first);
    }
    public static boolean iguales(MyLinkedList lista, MyLinkedList lista1){
        Node temp = lista.first;
        Node temp1 = lista1.first;
        if(lista.size() != lista1.size()) return false;
        else{
            for(int i =1; i< lista.size();i++){
                if(lista.get(i)!= lista1.get(i) ) 
                return false;
            }
            return true;
        }
    }
    public static void main(String[] args)
    {
    	
    	MyLinkedList list = new MyLinkedList();
    	list.insert(1, 0);
    	list.insert(2, 1);
    	list.insert(3, 2);
    	list.insert(4, 3);
    	list.insert(5, 4);
    	
    	MyLinkedList list1 = list;
    	System.out.println(maximo(list1));
    	System.out.println(iguales(list, list1));
    }
}
