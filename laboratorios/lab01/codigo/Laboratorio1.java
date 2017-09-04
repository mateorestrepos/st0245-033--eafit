import java.util.concurrent.TimeUnit;

import java.util.Random;


public class Laboratorio1

{
    
	//ArrayMax Recursivo
    
	/**
         
	* @param array A given array of integers. 
         
	* @param n An given integer that works as an index.
         
	* @return Returns an integer value, which is the highest number in the array.
         
	*/
    
	public static int arrayMax(int[] array, int n) 
	{
        
        
		int max=array[n];
        
		int temp;
        
		try
            
		{
                
			timeUnit.MILLISECONDS.sleep(100);
            
		}
            
		catch(Exception e)
            
		{
                
			System.out.println("Algo está mal");
            
		}
        
		if( n != 0) 
		{
            
			temp = arrayMax(array, n - 1);
            
			if( temp > max)
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
         
	* @param a A given array of integers. 
         
	* @param n An given integer that works as an index.
         
	* @return Returns an integer value, which is the sum of all element in the array.
         
	* @see Laboratorio1#aux(int[])
         
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
    
	//Fibonacci Recursivo
    
	/**
         
	* @param n A given integer number.
         
	* @return Returns the value of the F(n) Fibonacci number.
         
	*/
    
	public static long fibonacci(int n) 
	{ 
        
		if( n <= 1) 
            
			return n;
        
		try
        
		{
            
			TimeUnit.MILLISECONDS.sleep(100);
        
		}
        
		catch(Exception e)
        
		{
            
			System.out.println("Algo está mal");
        
		}
        
		return fibonacci(n-1) + fibonacci(n-2);
    
	}
    
	//Random array
	/**
         
	* @param n A given number refering to the length of the resulting array.
         
	* @return Returns an array of integer numbers smaller than 5000.
         
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
         
	* @param n A given integer that refers the length of an array.
         
	* @return Returns a long value, which is the time it took a process to be made.
         
	* @see Laboratorio1#random(int)
         * @see Laboratorio1#arraySum(int[], int)
         
	* @see Laboratorio1#arrayMax(int[], int)
         * @see Laboratorio1#fibonacci(int)
         
	*/
    
	public static long tomarTiempo(int n)
    
	{
        
		int [] A = random(n);
        
		long startTime = System.currentTimeMillis();
        
		//arrayMax(A, A.length - 1);
        
		arraySum(A, A.length - 1);
        
		//fibonacci(n);
        
		long estimatedTime = System.currentTimeMillis() - startTime;
        
		return estimatedTime;
    
	}

}