import java.util.concurrent.TimeUnit;
import java.util.Random;
public class Laboratorio2
{
    //ArrayMax Recursivo
    /**
         * @param a Un arreglo dado de enteros. 
         * @param n Un entero dado que funciona como índice.
         * @return Retorna un valor entero, que refiere el mayor valor dentro del arreglo.
         * @see Laboratorio2#tomarTiempo(int)
         */
    public static int arrayMax(int[] a, int n) {
        int max=a[n];
        int temp;
        try
        {
            TimeUnit.MILLISECONDS.sleep(100);
        }
        catch(Exception e)
        {
            System.out.println("Algo está mal");
        }
        if (n != 0)
        {
            temp = arrayMax(a, n - 1);
            if (temp > max)
            {
                max = temp;
            }
        }
        return max;
    }
    //ArraySum Recursivo
    public static int aux (int [] a) 
    { 
        return arraySum (a, a.length - 1); 
    }
    /**
         * @param a Un arreglo dado de enteros. 
         * @param n Un entero dado que funciona como índice.
         * @return Retorna un valor entero que refiere a la suma de todos los elementos del arreglo.
         * @see Laboratorio2#aux(int[])
         * @see Laboratorio2#tomarTiempo(int)
         */
    public static int arraySum(int[] a, int n)
    { 
        if(n < 1)
            return a[n]; 
        try
        {
            TimeUnit.MILLISECONDS.sleep(100);
        }
        catch(Exception e)
        {
            System.out.println("Algo está mal");
        }
        return a[n] + arraySum(a, n - 1);
    }
    //Genera un array aleatorio con números menores a 5000
    /**
         * @param n Un entero dado que refiere la longitud del qrreglo resultante.
         * @return Retorna un array cuyos elementos son menores a 5000.
         * @see Laboratorio2#tomarTiempo(int)
         */
    public static int [] random(int n)
    {
        int max = 5000;
        int [] A = new int [n];
        Random generator = new Random();
        for (int i = 0; i < n; i++)
        {
            A[i] = generator.nextInt(max);
        }
        return A;
    }
    //InsertionSort
    /**
         * @param a Un arreglo dado a ser ordenado.
         * @see Laboratorio2#tomarTiempo(int)
         */
    public static void insertionSort(int [] a)
    {
        int aux;
        for (int i = 0; i < a.length; i++)
        {
            for (int j = i + 1; j < a.length; j++)
            {
                try
                {
                    TimeUnit.MILLISECONDS.sleep(100);
                }
                catch(Exception e)
                {
                    System.out.println("Algo está mal");
                }
                if (a[i] > a[j])
                {
                    aux = a[i];
                    a[i] = a[j];
                    a[j] = aux;
                }
            }
        }
    }
    //MergeSort
    /**
         * @param a Un arreglo dado a ser ordenado.
         * @param temp Un arreglo auxiliar que servirá de apoyo para ordenar el arreglo original.
         * @param izquierda El índice del elemento más a la izquierda en el arreglo.
         * @param derecha El índice del elemento más a la derecha en el arreglo.
         * @see Laboratorio2#mergeAux(int[], int[], int, int)
         * @see Laboratorio2#tomarTiempo(int)
         */
    public static void mergeSort(int [] a, int [] temp, int izquierda, int derecha)
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(100);
        }
        catch(Exception e)
        {
            System.out.println("Algo está mal");
        }
        if (izquierda >= derecha)
            return;
        else
        {
            int medio = (derecha + izquierda) / 2;
            mergeSort(a, temp, izquierda, medio);
            mergeSort(a, temp, medio + 1, derecha);
            mergeAux(a, temp, izquierda, derecha);
        }
    }
    //MergeAux
    /**
         * @param a Un arreglo dado a ser ordenado.
         * @param temp Un arreglo auxiliar que servirá de apoyo para ordenar el arreglo original.
         * @param x El índice del elemento más a la izquierda en el arreglo.
         * @param y El índice del elemento más a la derecha en el arreglo.
         * @see Laboratorio2#mergeSort(int[], int[], int, int)
         * @see Laboratorio2#tomarTiempo(int)
         */
    public static void mergeAux(int [] a, int [] temp, int izquierda, int derecha)
    {
        int izquierdaAux = (izquierda + derecha) / 2;
        int derechaAux = izquierdaAux + 1;
        int size = derecha - izquierda + 1;
        
        int x = izquierda;
        int y = derechaAux;
        int i = izquierda;
        while (x <= izquierdaAux && y <= derecha)
        {
            if (a[x] <= a[y])
            {
                temp[i] = a[x];
                x++;
            }
            else
            {
                temp[i] = a[y];
                y++;
            }
            i++;
        }
        System.arraycopy(a, x, temp, i, izquierdaAux - x + 1);
        System.arraycopy(a, y, temp, i, derecha - y + 1);
        System.arraycopy(temp, izquierda, a, izquierda, size);
    }
    //Main
    public static void main (String args [])
    {
        for(int i = 1; i <= 50; i++)
        {
            System.out.println(i + " " + tomarTiempo(i)*100);
        }
    }
    //Tomar Tiempo
    /**
         * @param n Un elemento dado que refiere a la longitud del arreglo.
         * @return Retorna un valor tipo long, lo cual es el tiempo que tardó en completarse un proceso.
         * @see Laboratorio2#random(int)
         * @see Laboratorio2#arraySum(int[], int)
         * @see Laboratorio2#arrayMax(int[], int)
         * @see Laboratorio2#insertionSort(int[])
         * @see Laboratorio2#mergeSort(int[], int[], int, int)
         */
    public static long tomarTiempo(int n)
    {
        int [] A = random(n);
        long startTime = System.currentTimeMillis();
        //arrayMax(A, A.length - 1);
        //arraySum(A, A.length - 1);
        //insertionSort(A);
        mergeSort(A, new int [A.length], 0, A.length - 1);
        long estimatedTime = System.currentTimeMillis() - startTime;
        return estimatedTime;
    }
}
