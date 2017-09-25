import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Laboratorio3
{
    //Product
    /**
     * @param lista Lista de enteros.
     * @return Producto de los elementos de la lista.
     */
    public static int product (List<Integer> lista)
    {
        int producto = 1;                                   
        for (int i = 0; i < lista.size(); i++)             
        {
            producto = producto * lista.get(i);             
        }
        return producto;                                   
    }
    //SmartInsert
    /**
     * @param lista Lista de enteros.
     * @param dato Elemento a añadir a la lista.
     */
    public static void smartInsert(List<Integer> lista, int dato)
    {
        if (!lista.contains(dato))                         
            lista.add(lista.size(), dato);                  
    }
    //Pivote
    /**
     * @param lista Lista de enteros.
     * @return Elemento de la lista que servirá de pivote.
     * @see Laboratorio3#listSum(List)
     */
    public static int pivote (List<Integer> lista)                                                                  
    {
        int pivote = lista.get(1);                                                                                  
        int balance = Math.abs(listSum(lista.subList(0, 1)) - listSum(lista.subList(2, lista.size())));             
        for (int i = 2; i < lista.size() - 1; i++)                                                                  
        {
            if (Math.abs(listSum(lista.subList(0, i)) - listSum(lista.subList(i + 1, lista.size()))) <= balance)    
            {
                balance = Math.abs(listSum(lista.subList(0, i)) - listSum(lista.subList(i + 1, lista.size())));     
                pivote = lista.get(i);                                                                              
            }
        }
        return pivote;                                                                                             
    }
    //ListSum
    /**
     * @param lista Lista de enteros.
     * @return Suma de los elementos de la lista.
     * @see Laboratorio3#pivote(List)
     */
    public static int listSum (List<Integer> lista)     
    {
        int suma = 0;                                   
        for (int i = 0; i < lista.size(); i++)       
        {
            suma = suma + lista.get(i);                
        }
        return suma;                                  
    }
    //Neveras
    /**
     * @param neveras Lista de cadenas que corresponde al código y descripción de cada nevera.
     * @param solicitudes Lista de cadenas que corresponde al cliente y la cantidad de neveras que comprará.
     * @see Laboratorio3#ingresarNevera(LinkedList, int, String)
     * @see Laboratorio3#ingresarSolicitud(LinkedList, int, String)
     */
    public static void ejercicio4(LinkedList<String> neveras, LinkedList<String> solicitudes)
    {
        LinkedList<String> entregas = new LinkedList<String>();
        int aux = neveras.size();
        int cantidad = 0;
        String str, str1;
        for (int i = solicitudes.size() - 1; i >= 0; i--)
        {
            str  = solicitudes.get(i).substring(solicitudes.get(i).length() - 2, solicitudes.get(i).length() - 1);
            str1 = solicitudes.get(i).substring(solicitudes.get(i).length() - 3, solicitudes.get(i).length() - 2);
            if (str.matches(".*\\d.*") && !str1.matches(".*\\d.*"))
            {
                cantidad = Integer.parseInt(str);
                if (cantidad < aux)
                    entregas.add(solicitudes.get(i).substring(0, solicitudes.get(i).length() - 4) + ", " + neveras.subList(aux - cantidad, aux) + ")");
                    else
                    entregas.add(solicitudes.get(i).substring(0, solicitudes.get(i).length() - 4) + ", " + neveras.subList(0, aux) + ")");
            }
            else if (str1.matches(".*\\d.*"))
            {
                cantidad = Integer.parseInt(str1 + str);
                if (cantidad < aux)
                    entregas.add(solicitudes.get(i).substring(0, solicitudes.get(i).length() - 5) + ", " + neveras.subList(aux - cantidad, aux) + ")");
                    else
                    entregas.add(solicitudes.get(i).substring(0, solicitudes.get(i).length() - 5) + ", " + neveras.subList(0, aux) + ")");
            }
            aux = aux - cantidad;
        }
        System.out.println(entregas);
    }
    //IngresarNevera
    /**
     * @param lista Lista de cadenas en la cual se insertarán las características de cada nevera.
     * @param codigo Código de la nevera que se va a insertar en la lista.
     * @param descripcion Referencia de la nevera que se va a insertar en la lista.
     * @see Laboratorio3#ejercicio4(LinkedList, LinkedList)
     */
    public static void ingresarNevera(LinkedList<String> lista, int codigo, String descripcion)
    {
        String nevera = "(" + codigo + ", " + descripcion + ")";
        lista.add(nevera);
    }
    //IngresarSolicitud
    /**
     * @param lista Lista de cadenas en la cual se insertarán las características de cada solicitud.
     * @param cantidad Cantidad de neveras que el cliente comprará.
     * @param cliente Solicitante de la compra de cada nevera.
     * @see Laboratorio3#ejercicio4(LinkedList, LinkedList)
     */
    public static void ingresarSolicitud(LinkedList<String> lista, int cantidad, String cliente)
    {
        String solicitud = "(" + cliente + ", " + cantidad + ")";
        lista.add(0, solicitud);
    }
    //MAIN
    public static void main (String [] args)
    {
        ArrayList<Integer> ejemploAL = new ArrayList<Integer>();
        ejemploAL.add(10);
        ejemploAL.add(2);
        ejemploAL.add(5);
        ejemploAL.add(2);
        ejemploAL.add(11);
        
        LinkedList<Integer> ejemploLL = new LinkedList<Integer>();
        ejemploLL.add(2);
        ejemploLL.add(7);
        ejemploLL.add(3);
        ejemploLL.add(11);
        ejemploLL.add(9);
        
        System.out.println("ArrayList: " + ejemploAL);
        System.out.println("LinkedList: " + ejemploLL);
        System.out.println();
        System.out.println("Producto ArrayList: " + product(ejemploAL));
        System.out.println("Producto LinkedList: " + product(ejemploLL));
        System.out.println();
        System.out.println("Pivote ArrayList: " + pivote(ejemploAL));
        System.out.println("Pivote LinkedList: " + pivote(ejemploLL));
        System.out.println();
        smartInsert(ejemploAL, 5);
        System.out.println("Añado dato existente (5) a ArrayList: " + ejemploAL);
        smartInsert(ejemploAL, 4);
        System.out.println("Añado dato nuevo (4) a ArrayList: " + ejemploAL);
        smartInsert(ejemploLL, 7);
        System.out.println("Añado dato existente (7) a LinkedList: " + ejemploLL);
        smartInsert(ejemploLL, 6);
        System.out.println("Añado dato nuevo (6) a LinkedList: " + ejemploLL);
        
        LinkedList<String> neveras = new LinkedList<String>();
        ingresarNevera(neveras, 1, "haceb");
        ingresarNevera(neveras, 2, "lg");
        ingresarNevera(neveras, 3, "samsung");
        ingresarNevera(neveras, 4, "haceb");
        ingresarNevera(neveras, 5, "lg");
        ingresarNevera(neveras, 6, "samsung");
        ingresarNevera(neveras, 7, "haceb");
        ingresarNevera(neveras, 8, "lg");
        ingresarNevera(neveras, 9, "samsung");
        ingresarNevera(neveras, 8, "lg");
        ingresarNevera(neveras, 9, "samsung");
        
        LinkedList<String> solicitudes = new LinkedList<String>();
        ingresarSolicitud(solicitudes, 1, "exito");
        ingresarSolicitud(solicitudes, 4, "olimpica");
        ingresarSolicitud(solicitudes, 2, "la14");
        ingresarSolicitud(solicitudes, 10, "eafit");
        
        LinkedList<String> entregas = new LinkedList<String>();
        System.out.println();
        System.out.println("Neveras: " + neveras);
        System.out.println("Solicitudes: " + solicitudes);
        System.out.println();
        System.out.print("Entregas: ");
        ejercicio4(neveras, solicitudes);
    }
}