/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

public class Laboratorio5 {
    

   public static void dibujarArbol(BinarySearchTree a)
   {
       System.out.println("/* arbolito para http://www.webgraphviz.com/ */"); 
       System.out.println("digraph arbolito {");
       System.out.println("size=\"6,6\";");
       System.out.println("node [color=aquamarine, style=filled];");
       dibujarArbolAux(a.root);
       System.out.println("}");
   }
   
   public static void dibujarArbolAux(Node nodo)
   {
      if (nodo != null)
         //"x_\n__" -> "xo\n__";
         for(Node n: new Node[] {nodo.left, nodo.right} ){
            if (n != null)
               System.out.println("\"" + nodo.data + "\" -> \"" + n.data + "\";");
            dibujarArbolAux(n);
        }
   }
   
   

    
    public static void main(String[] args) {
    
        //Crea el árbol familiar
        BinarySearchTree tree = new BinarySearchTree();
        
        tree.insertar("Mateo", true, null);
        tree.insertar("Jorge", true,"Mateo");
        tree.insertar("Adriana", false, "Mateo");
        tree.insertar("Julio", true, "Jorge");
        tree.insertar("Guillermo", true, "Adriana");
        tree.insertar("Elvia", false, "Jorge");
        tree.insertar("Isabel", false, "Adriana");
        tree.insertar("Maria", false, "Elvia");
        tree.insertar("Jesus", true, "Elvia");
        tree.insertar("Laura", false, "Julio");
        tree.insertar("Angel", true, "Julio");
        tree.insertar("Luis", true, "Isabel");
        tree.insertar("Magdalena", false, "Isabel");
        tree.insertar("Roberto", true, "Guillermo");        
        tree.insertar("Diana", false, "Guillermo");                
        
                   
        
        //Imprime el árbol familiar
        tree.recursivePrint();
        System.out.println();

        //Dibuja el árbol familiar
        dibujarArbol(tree);
        System.out.println();
        
        //Imprime la altura del arbol del arbol
        System.out.println("La altura del arbol es: "+ tree.altura()+" niveles");
        System.out.println();
        
        //Imprime el tamaño del arbol
        System.out.println("El tamaño del arbol es: "+tree.tamaño()+ " nodos");
        System.out.println();
        
        //Mira si alguien esta en el arbol
        String a = "Andres";
        Boolean siEsta = tree.buscar(a);
        if(siEsta){
            System.out.println( a +" si esta en el arbol");
        }else{
            System.out.println(a +" no esta en el arbol");
        }
    }
}
