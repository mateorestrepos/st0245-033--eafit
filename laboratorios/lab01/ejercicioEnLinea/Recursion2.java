public class Recursion2
{
    
	//GroupSum
    
	public boolean groupSum(int start, int[] nums, int target) { 
        
		if (start >= nums.length)                                    
            
			return (target == 0);                                    
        
		return groupSum(start + 1, nums, target - nums[start]) || groupSum(start + 1, nums, target);                    
    
	} 
    
	//GroupSum6
    
	public boolean groupSum6(int start, int[] nums, int target) { 
        
		if (start >= nums.length)                                    
            
			return target == 0;                                        
        
		if (nums[start] == 6)                                
            
			return groupSum6(start + 1, nums, target - nums[start]);
        
		return groupSum6(start + 1, nums, target - nums[start]) || groupSum6(start + 1, nums, target);              
    
	}
    
	//GroupNoAdj
    
	public boolean groupNoAdj(int start, int[] nums, int target) { 
        
		if (start >= nums.length)                                    
            
			return target == 0;                                   
        
		return groupNoAdj(start + 2, nums, target - nums[start]) || groupNoAdj(start + 1, nums, target);             
    
	}
    
	//GroupSum5
    
	public boolean groupSum5(int start, int [] nums, int target) {
        
		if (start >= nums.length)                                  
            
			return target == 0;                                     
        
		if (nums[start] % 5 == 0){                                
            
			if (start < nums.length - 1 && nums[start + 1] == 1)    
                
				return groupSum5(start + 2, nums, target - nums[start]);
            
			return groupSum5(start + 1, nums, target - nums[start]);
        
		}     
        
	return groupSum5(start + 1, nums, target - nums[start]) || groupSum5(start + 1, nums, target);
    
	}
    
	//GroupSumClump
    
	public boolean groupSumClump(int start, int[] nums, int target) { 
        
		if (start >= nums.length)                                 
            
			return target == 0;                                 
        
		int suma = nums[start];                                
        
		int count = 1;                                           
        
		for (int i = start + 1; i < nums.length; i++){          
            
			if (nums[i] == nums[start]){                          
                
				suma += nums[i];                                     
                
				count++;                                           
            
			} 
        
		} 
        
		return groupSumClump(start + count, nums, target - suma) || groupSumClump(start + count, nums, target); 
    
	}

}
