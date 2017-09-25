import java.util.Scanner;
import java.util.LinkedList;
public class TextoErroneo
{
    public static void textoErroneo(LinkedList<String> lista)
    {
        LinkedList<String> lista1 = new LinkedList<String>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la linea que se desea corregir");
        String line = scan.nextLine();
        String line1 = line.replaceAll("_", " ");
        String aux = "";
        for (int i = line1.length() - 1; i >= 0; i--)
        {
            aux = line1.charAt(i) + aux;
            if (line.charAt(i) == '[')
            {
                aux = aux.substring(1, aux.length());
                lista1.add(0, aux);
                aux = "";
            }
            else if (line.charAt(i) == ']')
            {
                aux = aux.substring(1, aux.length());
                lista.add(aux);
                aux = "";
            }
            else if (i == 0)
                lista.add(aux);
        }
        lista.addAll(lista1);
    }
    
    public static void imprimirLista(LinkedList<String> lista)
    {
        String salida = "";
        for (int i = 0; i < lista.size(); i++)
        {
            salida = lista.get(i) + salida;
        }
        System.out.println(salida);
    }
    
    public static void main (String [] args)
    {
        LinkedList<String> lista = new LinkedList<String>();
        textoErroneo(lista);
        imprimirLista(lista);
    }
}
