/*
 * Mateo Restrepo Sierra
 * Nicolas Restrepo Lopez
 */
package lab5;

public class BinarySearchTree {
    Node root ;
    public BinarySearchTree () {
        root = null ;
    }
     
    public void insertar(String n, Boolean hombre, String hijo) {
        if(hijo != null){
             Node son = buscar(root, hijo);
             if(hombre){
                 son.right = new Node(n);
             }
             else son.left = new Node(n);
        }
        else {
            root = new Node(n);
        }
    } 

        
    private Node buscar(Node n, String a)
    {
         if(n != null){
            if (n.data.equals(a)){
                return n;
            }
            Node right = buscar(n.right, a);
            if(right != null){
                return right;
            }
            else{
                return buscar(n.left, a);
            }
         }
        return n;
    }
    public Boolean buscar(String n) {
        Node node = buscar(root, n);
        return node != null;
    }
        
    public void borrar(String n, Boolean hombre) {
        root = borrar(root, n, hombre);
    }
    private Node borrar(Node nodo, String a, Boolean hombre){
         if(nodo.data.equals(a)){
                Node aux = max(nodo.left);
                aux.right = nodo.right;
                nodo = nodo.left;
                return nodo; 
         }
         else{
             if(hombre){
                nodo.right = borrar(nodo.right, a, hombre);
                return nodo;
         }
         else {
                nodo.left = borrar(nodo.left, a, hombre);
                return nodo;
         }
        }
    }
    private Node max(Node nodo){
        if(nodo.right == null){
            return nodo;
        }
        return max(nodo.right);
    }
      
    private int altura(Node nodo){
        if (nodo == null){
                return 0;
            } else {
                int left = altura(nodo.left);
                int right = altura(nodo.right);
                return 1 + Math.max(left,right);
            }
    }
    public int altura(){
        return altura(root);
    }
    
    public int tamaño(){
        return tamaño(root);
    }
    private int tamaño(Node nodo){
           if (nodo == null){
                return 0;
            }else {
                int left = tamaño(nodo.left);
                int right = tamaño(nodo.right);
                return 1 + left + right;
            }
    }
    
    public void recursivePrint(){
        recursivePrint(root);
    }
    private void recursivePrint(Node nodo){
        if(nodo == null){
            return;
        }else{
            recursivePrint(nodo.left);
            System.out.println(nodo.data);
            recursivePrint(nodo.right);
        }
    }
    
    public Node setGrandMothersName (Node node, String name){
        Node nulo = new Node(null); 
        if(buscar(name)){
            Node n = buscar(root,name);
            if(n.left == null || n.left.left  == null){
                return nulo;
            }
            return n.left.left; 
        }
        return nulo;
        
    }
    public String getGrandMothersName(String name){
        Node n = setGrandMothersName(root, name);
        if(n == null){
            return "";
        }
        else {
            return n.data; 
        }
    }
}
