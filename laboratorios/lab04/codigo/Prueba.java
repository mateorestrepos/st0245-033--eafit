public class Prueba
{
    public static void main (String [] args)
    {
        LinkedListMauricio ejemplo = new LinkedListMauricio();
        ejemplo.insert(5, 0);
        ejemplo.insert(4, 1);
        ejemplo.insert(7, 2);
        ejemplo.insert(1, 0);
        ejemplo.insert(9, 4);
        ejemplo.insert(8, 2);
        System.out.print("Imprimo lista: {");
        for (int i = 0; i < ejemplo.size() - 1; i++)
        {
            System.out.print(ejemplo.get(i) + ", ");
        }
        System.out.println(ejemplo.get(ejemplo.size() - 1) + "}");
        
        ejemplo.remove(4);
        System.out.print("Elimino nodo en la posición 4: {");
        for (int i = 0; i < ejemplo.size() - 1; i++)
        {
            System.out.print(ejemplo.get(i) + ", ");
        }
        System.out.println(ejemplo.get(ejemplo.size() - 1) + "}");
        
        System.out.println("La lista contiene a 9: " + ejemplo.contains(9));
        System.out.println("La lista contiene a 2: " + ejemplo.contains(2));
    }
}
