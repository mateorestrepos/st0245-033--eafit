public class Punto3
{
    public static void main (String [] args)
    {
        BinarySearchTree familiaNico = new BinarySearchTree();
        
        familiaNico.insertar("Nicolas", true, null);
        familiaNico.insertar("Mauricio", true, "Nicolas");
        familiaNico.insertar("Adriana", false, "Nicolas");
        familiaNico.insertar("Gustavo", true, "Mauricio");
        familiaNico.insertar("Cecilia", false, "Mauricio");
        familiaNico.insertar("Luis", true, "Adriana");
        familiaNico.insertar("Trinidad", false, "Adriana");
        familiaNico.insertar("Ezequiel", true, "Gustavo");
        familiaNico.insertar("Elvira", false, "Gustavo");
        familiaNico.insertar(" ", true, "Cecilia");
        familiaNico.insertar("Maria", false, "Cecilia");
        familiaNico.insertar("", true, "Luis");
        familiaNico.insertar("  ", false, "Luis");
        familiaNico.insertar("Ernesto", true, "Trinidad");
        familiaNico.insertar("Adelfa", false, "Trinidad");
        
        familiaNico.recursivePrint();
        System.out.println();
        //Dibuja el árbol familiar
        Punto1.dibujarArbol(familiaNico);
        System.out.println();
    }
}