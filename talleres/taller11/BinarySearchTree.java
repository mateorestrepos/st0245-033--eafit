public class BinarySearchTree {
    Node root ;
    public BinarySearchTree () {
        root = null ;
    }
     
    public void insertar(int n) {
        root = insertar(root,n);
    } 
    private Node insertar(Node nodo, int n){
        if(nodo==null){
            return new Node(n);
        }
        else if( nodo.data < n ){
            nodo.right= insertar(nodo.right, n);
            return nodo; 
        } 
        nodo.left = insertar(nodo.left,n);
        return nodo;
    }
        
    private boolean buscar(Node n, int a)
    {
         if(n != null){
            if (n.data == a){
                return true;
            }
            else if(n.data < a){
                return buscar(n.right, a);
            }
            else if(n.data > a){ 
                return buscar(n.left, a);
            }
        }
        return false;
    }
    public boolean buscar(int n) {
        return buscar(root, n);
    }
        
    public void borrar(int n) {
        root = borrar(root, n);
    }
    private Node borrar(Node nodo, int a){
         if(nodo.data == a){
                Node aux = max(nodo.left);
                aux.right = nodo.right;
                nodo = nodo.left;
                return nodo; 
         }
         else{
             if( nodo.data <= a){
                nodo.right = borrar(nodo.right,a);
                return nodo;
         }
         else {
                nodo.left = borrar(nodo.left,a);
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
}
