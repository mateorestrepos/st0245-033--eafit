
public class Recursion1

{
    
	//Factorial
    
	public int factorial(int n) { 
        
		if(n == 1) 										
            
			return 1;  									
        
	return n * factorial(n - 1);						
    
	} 
    
	//BunnyEars
    
	public int bunnyEars(int bunnies) { 
        
		if (bunnies == 0) 								
            
			return 0;										
        
		return 2 + bunnyEars(bunnies - 1);				
    
	}  
    
	//Fibonacci
    
	public int fibonacci(int n) { 
        
		if (n <= 1) 										
            
			return n;										
        
		return fibonacci(n - 2) + fibonacci(n - 1);  
    
	} 
    
	//BunnyEars2
    
	public int bunnyEars2(int bunnies) { 
        
		if (bunnies == 0)                     		
            
			return bunnies;                       	
        
		if (bunnies % 2 == 1)                    	
            
			return 2 + bunnyEars2(bunnies - 1);    	
        
	return 3 + bunnyEars2(bunnies - 1);    	
    
	} 
    
	//Array220
    
	public boolean array220(int[] nums, int index) { 
       
		if (nums.length < 2 || index == nums.length - 1)
          
			return false;										
       
		if (nums[index + 1] == nums[index] * 10)			
          
			return true;										
       
	return array220(nums, index + 1);					
    
}
 
}
