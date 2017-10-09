import java.util.Queue;
import java.util.LinkedList;
public class Banco
{
    private int [] cajero;
    private Queue<String> [] filas;
    public Banco ()
    {
        cajero = new int[2];
        filas = new Queue[4];
        for (int i = 0; i < 4; i++)
        {
            filas[i] = new LinkedList<String>();
        }
    }
    /**
    * Simula un banco en el cual hay dos cajeros y cuatro filas.
    */
    public void simulacion()
    {
        boolean [] sigue = new boolean[4];
        sigue[0] = true;
        sigue[1] = true;
        sigue[2] = true;
        sigue[3] = true;
        int x = 0;
        while (filas[0].peek() != null || filas[1].peek() != null || filas[2].peek() != null || filas[3].peek() != null)
        {
            int n = 0;
            for (int i = 0; i < 4; i++)
            {
                if (filas[i].peek() == null)
                {
                    sigue[i] = false;
                }
                    
                else if (filas[i].peek() != null && sigue[i])
                {
                    System.out.println("Cajero " + (x + 1) + ": " + filas[i].remove());
                    sigue[i] = false;
                    break;
                }
            }
            for (int i = 0; i < 4; i++)
            {
                if (!sigue[i])
                    n++;
            }
            if (n == 4)
            {
                sigue[0] = true;
                sigue[1] = true;
                sigue[2] = true;
                sigue[3] = true;
            }
            x++;
            x = x % 2;
        }
    }
    public static void main (String [] args)
    {
        Banco ejemplo = new Banco();
        
        ejemplo.filas[0].add("Mateo");
        ejemplo.filas[0].add("Nicolas");
        ejemplo.filas[0].add("Sofia");
        ejemplo.filas[0].add("Alejandro");
        
        ejemplo.filas[1].add("Alejandra");
        ejemplo.filas[1].add("Daniel");
        ejemplo.filas[1].add("David");
        ejemplo.filas[1].add("Catalina");
        ejemplo.filas[1].add("Santiago");
        
        ejemplo.filas[2].add("Mauricio");
        ejemplo.filas[2].add("Simon");
        ejemplo.filas[2].add("Jose");
        
        ejemplo.filas[3].add("Laura");
        ejemplo.filas[3].add("Daniela");
        ejemplo.filas[3].add("Carlos");
        ejemplo.filas[3].add("Sebastian");
        
        for (int i = 0; i < 4; i++)
            System.out.println("Fila " + (i + 1) + ": " + ejemplo.filas[i]);
            
        System.out.println();    
        ejemplo.simulacion();
    }
}